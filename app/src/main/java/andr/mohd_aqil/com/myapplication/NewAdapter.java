package andr.mohd_aqil.com.myapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

/**
 * Created by Localadmin on 1/24/2017.
 */

public class NewAdapter extends RecyclerView.Adapter<NewAdapter.ViewHolder> {
    private List<String> mDataset;
    Context context;

    public class ViewHolder extends RecyclerView.ViewHolder {


        public ViewHolder(View v) {
            super(v);


        }
    }

    public NewAdapter(Context context, List<String> myDataset) {
        mDataset = myDataset;
        this.context=context;

    }

     @Override
    public NewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.newdapter, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);

        return vh;
    }
    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public void onBindViewHolder(NewAdapter.ViewHolder holder, final int position) {

       



    }

  


  

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
   

  }
