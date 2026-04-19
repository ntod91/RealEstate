package com.realestate.app.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.realestate.app.R
import com.realestate.app.domain.models.RealEstateDomain
import com.realestate.app.ui.theme.SpinnerColor
import com.realestate.app.utils.Defaults
import com.realestate.app.utils.Resource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel()) {
    Scaffold { innerPadding ->
        val resource by viewModel.realEstateState.collectAsStateWithLifecycle()
        when (resource) {
            is Resource.Error<List<RealEstateDomain>> -> {
                Column(
                    Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = stringResource(R.string.text_error_title),
                        modifier = Modifier.padding(12.dp)
                    )

                    Text(
                        text = resource.message ?: Defaults.CONTENT_DESCRIPTION,
                        modifier = Modifier.padding(12.dp)
                    )
                    Button(
                        onClick = { viewModel.refreshData() }, modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = stringResource(R.string.button_action_reload),
                            modifier = Modifier.padding(12.dp)
                        )
                    }
                }
            }

            is Resource.Loading<List<RealEstateDomain>> -> {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator(Modifier, color = SpinnerColor)
                }
            }

            is Resource.Success<List<RealEstateDomain>> -> {
                resource.data?.let {
                    PullToRefreshBox(
                        isRefreshing = false, onRefresh = {
                            viewModel.refreshData()
                        }) {
                        HomeScreenContent(
                            innerPadding, it, onBookmarked = viewModel::bookmarkRealEstate
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun HomeScreenContent(
    innerPadding: PaddingValues, data: List<RealEstateDomain>, onBookmarked: (Long, Boolean) -> Unit
) {
    Box(
        modifier = Modifier
            .padding(innerPadding)
            .padding(16.dp)
    ) {
        val listState = rememberLazyListState()

        LazyColumn(
            state = listState, modifier = Modifier
        ) {
            itemsIndexed(data) { _, value ->
                Column(
                    modifier = Modifier.border(
                        width = 1.dp, color = Color.Black, shape = RoundedCornerShape(4.dp)
                    )
                ) {
                    RealEstateItem(value, onBookmarked)
                }
                Spacer(Modifier.padding(top = 16.dp))
            }
        }
    }
}

@Composable
private fun RealEstateItem(value: RealEstateDomain, onBookmarked: (Long, Boolean) -> Unit) {
    ImageContent(value, onBookmarked)
    Footer(value)
}

@Composable
private fun ImageContent(
    realEstateDomain: RealEstateDomain, onBookmarked: (Long, Boolean) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                width = 2.dp, color = Color.Black, shape = RoundedCornerShape(4.dp)
            )
    ) {
        AsyncImage(
            modifier = Modifier
                .padding(2.dp)
                .aspectRatio(16f / 9f)
                .fillMaxWidth(),
            contentDescription = Defaults.CONTENT_DESCRIPTION,
            model = realEstateDomain.imageUrl,
            contentScale = ContentScale.Crop,
            placeholder = painterResource(R.drawable.ic_place_holder)
        )

        val resImage = if (realEstateDomain.isBookmarked) {
            R.drawable.ic_like_active
        } else {
            R.drawable.ic_like_inactive
        }

        Image(
            imageVector = ImageVector.vectorResource(resImage),
            modifier = Modifier
                .clickable {
                    onBookmarked(realEstateDomain.id, !realEstateDomain.isBookmarked)
                }
                .align(Alignment.TopEnd)
                .padding(8.dp),
            contentDescription = Defaults.CONTENT_DESCRIPTION)

        Box(
            modifier = Modifier
                .padding(2.dp)
                .background(color = Color.White)
                .align(Alignment.BottomStart)
                .border(
                    width = 1.dp, color = Color.Black, shape = RoundedCornerShape(1.dp)
                )
                .padding(2.dp),
        ) {
            Text(
                text = realEstateDomain.price,
                modifier = Modifier.padding(all = 2.dp),
                style = MaterialTheme.typography.labelMedium
            )
        }
    }
}

@Composable
private fun Footer(realEstateDomain: RealEstateDomain) {
    Column(
        Modifier.padding(all = 8.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            modifier = Modifier.padding(start = 8.dp),
            text = realEstateDomain.title + realEstateDomain.id.toString(),
            style = MaterialTheme.typography.labelMedium,
        )

        Spacer(Modifier.padding(vertical = 2.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_location),
                tint = Color.Green,
                contentDescription = Defaults.CONTENT_DESCRIPTION
            )

            Text(
                text = realEstateDomain.address,
                style = MaterialTheme.typography.labelSmall,
            )
        }
    }
}

@Preview
@Composable
fun PreviewHomeScreen() {
    HomeScreen(viewModel = hiltViewModel())
}
