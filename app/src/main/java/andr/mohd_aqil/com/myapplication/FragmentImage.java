package andr.mohd_aqil.com.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by localadmin on 6/12/2017.
 */

public class FragmentImage extends Fragment {


    NewAdapter mAdapter;

    @BindView(R.id.RvList)
    public RecyclerView recyclerView;

    LinearLayoutManager mLayoutManager;

    public List<String> FormList = new ArrayList();

    @Override
public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setHasOptionsMenu(true);
}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View viwe=inflater.inflate(R.layout.fragment_image, container, false);
        ButterKnife.bind(this,viwe);

          fillData();

        return viwe;
    }

    private void fillData() {
        FormList.add("1");
        FormList.add("2");
        FormList.add("3");
        FormList.add("4");
        recycleAdapter();
    }

    public  void recycleAdapter() {

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        // specify an adapter (see also next example)
        mAdapter = new NewAdapter(getActivity(),FormList);

        recyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }}