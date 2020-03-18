package com.example.mail;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
public class MailDetailFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_mail_detail,container,false);
        SharedPreferences sp= getActivity().getSharedPreferences("Data",Context.MODE_PRIVATE);
        String firstName=sp.getString("Mail","Value");
        String lastName=sp.getString("Name", "Value");
        String detail=sp.getString("Detail","Value");
        int image=sp.getInt("Image", 1);
//        Bundle bundle=getArguments();
//        String firstName=bundle.getString("Mail");
//        String lastName=bundle.getString("Name");
//        String detail=bundle.getString("Detail");
//        int image=bundle.getInt("Image");
        TextView firstText= view.findViewById(R.id.name);
        TextView secondText= view.findViewById(R.id.mail);
        TextView thirdText=view.findViewById(R.id.detality);
        ImageView imageView=view.findViewById(R.id.photo);
        firstText.setText(firstName);
        secondText.setText(lastName);
        thirdText.setText(detail);
        imageView.setImageResource(image);
        return view;
    }
}

