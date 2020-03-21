package com.steven.selectimage.ui.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.steven.selectimage.GlideApp;
import com.steven.selectimage.R;
import com.steven.selectimage.model.Image;
import com.steven.selectimage.widget.recyclerview.CommonRecycleAdapter;
import com.steven.selectimage.widget.recyclerview.CommonViewHolder;

import java.util.ArrayList;

/**
 * Description:
 * Data：9/4/2018-3:14 PM
 *
 * @author yanzhiwen
 */
public class SelectedImageAdapter extends CommonRecycleAdapter<Image> {
    private Context mContext;
    private ArrayList<Image> dataList;

    public SelectedImageAdapter(Context context, ArrayList<Image> data, int layoutId) {
        super(context, data, layoutId);
        this.mContext = context;
        dataList = data;
    }

    @Override
    protected void convert(CommonViewHolder holder, Image image, int position) {
        ImageView iv = holder.getView(R.id.iv_selected_image);
        TextView tvDelete = holder.getView(R.id.tv_delete);
        tvDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataList.remove(position);
                notifyDataSetChanged();
            }
        });
        GlideApp.with(mContext)
                .load(image.getPath())
                .centerCrop()
                .into(iv);
    }
}