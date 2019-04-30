package com.saliim.tekatekisilang;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.saliim.tekatekisilang.model.GetTts;

import java.util.ArrayList;
import java.util.List;

public class TtsAdapterMenurun extends RecyclerView.Adapter<TtsAdapterMenurun.TtsViewHolder> {
    private List<GetTts> dataSet;

    public TtsAdapterMenurun(ArrayList<GetTts> datas){
        dataSet = datas;
    }

    @Override
    public TtsViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list_tts, viewGroup, false);

        return new TtsViewHolder((itemView));
    }

    @Override
    public void onBindViewHolder(TtsViewHolder holder, int i) {
        GetTts dataTts = dataSet.get(i);

        holder.txtNoJenis.setText(dataTts.getNoSoal()+" "+dataTts.getJenis());
    }

    @Override
    public int getItemCount() {
        if (dataSet == null){
            return 0;
        } else {
            return dataSet.size();
        }
    }

    public class TtsViewHolder extends RecyclerView.ViewHolder {
        public TextView txtNoJenis;

        public TtsViewHolder(View itemView) {
            super(itemView);
            txtNoJenis = itemView.findViewById(R.id.txt_nomor_jenis);
        }
    }
}
