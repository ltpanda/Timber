package com.naman14.timber.fragments;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.naman14.timber.R;
import com.naman14.timber.adapters.AlbumAdapter;
import com.naman14.timber.dataloaders.AlbumLoader;
import com.naman14.timber.widgets.FastScroller;

/**
 * Created by naman on 07/07/15.
 */
public class AlbumFragment extends Fragment {

    private AlbumAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView =  inflater.inflate(
                R.layout.fragment_recyclerview, container, false);

        RecyclerView recyclerView=(RecyclerView) rootView.findViewById(R.id.recyclerview);

        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        FastScroller fastScroller=(FastScroller) rootView.findViewById(R.id.fastscroller);
        fastScroller.setVisibility(View.GONE);

        mAdapter = new AlbumAdapter(getActivity(), AlbumLoader.getAllAlbums(getActivity()));

        //to add spacing between cards
        int spacingInPixels = getActivity().getResources().getDimensionPixelSize(R.dimen.spacing_card_album_grid);
        recyclerView.addItemDecoration(new SpacesItemDecoration(spacingInPixels));

        recyclerView.setAdapter(mAdapter);


        return rootView;
    }

    public class SpacesItemDecoration extends RecyclerView.ItemDecoration {
        private int space;

        public SpacesItemDecoration(int space) {
            this.space = space;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view,
                                   RecyclerView parent, RecyclerView.State state) {


            outRect.left = space;
            outRect.top=space;
            outRect.right=space;
            outRect.bottom=space;

        }
    }

}

