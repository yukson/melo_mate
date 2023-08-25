package org.techtown.melomate;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.animation.ObjectAnimator;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.techtown.melomate.GetDate;
import org.techtown.melomate.GetTime;

import java.text.SimpleDateFormat;

public class SecondFragment extends Fragment {
    TextView textView2;
    ImageView imageView12;
    float startDegree = 0f;
    float endDegree = 0f;
    int hour = GetTime.getHour();
    int j = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);

        imageView12 = view.findViewById(R.id.imageView12);

        for(int i = 16; i<=23; i++){
            String tv_id = "textView" + i;
            int res_id = getResources().getIdentifier(tv_id, "id", "org.techtown.melomate");
            TextView textview = view.findViewById(res_id);
            if(textview != null){
                textview.setText(GetDate.addDate(j));
            }
            j++;
        }

        textView2 = view.findViewById(R.id.textView2);
        textView2.setText("현재기온(" + hour + "시)");

        imageView12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                rotate(v);
                textView2.setText("현재기온(" + hour + "시)");
            }
        });
        return view;
    }
    public void rotate(View v){
        endDegree = startDegree + 360;
        ObjectAnimator object = ObjectAnimator.ofFloat(imageView12, "rotation",
                startDegree, endDegree);
        object.setDuration(850);
        object.start();
    }

    public static SecondFragment newInstance(){
        return new SecondFragment();
    }
}
