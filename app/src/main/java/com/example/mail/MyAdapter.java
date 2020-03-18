package com.example.mail;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
public class MyAdapter extends RecyclerView.Adapter {
    Context mContext;
    SharedPreferences sp;
    public MyAdapter(Context context){
        mContext = context;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent,false);
        return new ListViewHolder(view, mContext);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ListViewHolder) holder).bindView(position);
    }

    @Override
    public int getItemCount() {
        return Mail.title.length;
    }

    private class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView itemText;
        private TextView itemSecondText;
        private TextView itemThirdText;
        private ImageView itemImage;
        int position;
        public ListViewHolder(View itemview, Context context){

            super(itemview);
            itemText=itemview.findViewById(R.id.people_name_txt);
            itemSecondText=itemview.findViewById(R.id.mail_txt);
            itemImage=itemview.findViewById(R.id.avatar);
            itemThirdText=itemview.findViewById(R.id.detail);
            itemview.setOnClickListener(this);
        }
        public void bindView (int position){
            this.position = position;
            itemText.setText(Mail.title[position]);
            itemSecondText.setText(Mail.information[position]);
            itemThirdText.setText(Mail.detail[position]);
            itemImage.setImageResource(Mail.picturePath[position]);
        }
        public void onClick(View view){
            String main=itemText.getText().toString();
            String inf=itemSecondText.getText().toString();
            String detail=itemThirdText.getText().toString();
            int image=Mail.picturePath[position];
            sp=mContext.getSharedPreferences("Data",mContext.MODE_PRIVATE);
            SharedPreferences.Editor editor=sp.edit();
            editor.putString("Name",inf);
            editor.putString("Mail",main);
            editor.putString("Detail",detail);
            editor.putInt("Image", image);
            editor.apply();
//            Bundle bundle=new Bundle();
//            bundle.putString("Name", inf);
//            bundle.putString("Mail", main);
//            bundle.putString("Detail", detail);
//            bundle.putInt("Image", image);
            MailDetailFragment mailDetailFragment=new MailDetailFragment();
//            mailDetailFragment.setArguments(bundle);
            FragmentManager fragmentManager= ((AppCompatActivity)mContext).getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.detailMail,mailDetailFragment).commit();

        }

    }
}

