package andr.mohd_aqil.com.myapplication;

import android.graphics.Typeface;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    CustomPagerAdapter mCustomPagerAdapter;

    @BindView(R.id.pager) ViewPager mViewPager;

    @BindView(R.id.viewpager) ViewPager viewpager;

    FragmentImage fragment;
    FragmentVideos fragmentv;
    FragmentMilestone fragmentm;


    @BindView(R.id.tv) TextView tvVideos;
    @BindView(R.id.v) ImageView imageVideios;
    @BindView(R.id.vv) View viewVideos;
    @BindView(R.id.ti) TextView tvImage;
    @BindView(R.id.i) ImageView imgeImge;
    @BindView(R.id.vi) View viewImgage;
    @BindView(R.id.tm) TextView tvMilestoe;
    @BindView(R.id.m) ImageView imageMilestone;
    @BindView(R.id.vm) View viewMilestone;



    Integer mDotsCount;

    public static TextView mDotsText[];

    @BindView(R.id.image_count)
    LinearLayout mDotsLayout;

    private ArrayList<String> images=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        viewpager.setOffscreenPageLimit(3);
        setupViewPager(viewpager);

        viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                int j=position+1;
                change(j);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        change(1);

        setAdapterValues();
        getId();




    }

    private void setupViewPager(ViewPager viewPager)
    {

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        fragmentv=new FragmentVideos();
        fragment=new FragmentImage();
        fragmentm=new FragmentMilestone();
        adapter.addFragment(fragmentv,"1");
        adapter.addFragment(fragment,"2");
        adapter.addFragment(fragmentm,"3");
        viewPager.setAdapter(adapter);
    }

    void setAdapterValues()
    {
        images.add(0,String.valueOf(R.drawable.a));
        images.add(1,String.valueOf(R.drawable.a));
        images.add(2,String.valueOf(R.drawable.a));
        images.add(3,String.valueOf(R.drawable.a));

    }

    private   void getId() {

        mCustomPagerAdapter = new CustomPagerAdapter(this);

        mViewPager.setAdapter(mCustomPagerAdapter);

        mDotsCount = mViewPager.getAdapter().getCount();

        mDotsText = new TextView[mDotsCount];

        //here we set the dots
        for(int i = 0; i < mDotsCount; i++) {
            mDotsText[i] = new TextView(MainActivity.this);
            mDotsText[i].setText(".");
            mDotsText[i].setTextSize(45);
            mDotsText[i].setTypeface(null, Typeface.BOLD);
            mDotsText[i].setTextColor(getResources().getColor(R.color.theme));
            mDotsLayout.addView(mDotsText[i]);
        }

        mDotsText[0].setTextColor(getResources().getColor(R.color.white));
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {



            }

            @Override
            public void onPageSelected(int position) {

                // TODO Auto-generated method stub
                for (int i = 0; i < images.size(); i++) {
                    mDotsText[i].setTextColor(getResources().getColor(R.color.theme));
                }
                mDotsText[position].setTextColor(getResources().getColor(R.color.white));

            }

            @Override
            public void onPageScrollStateChanged(int state) {


            }
        });
    }

    public  void change(int i) {

        Log.v("Position",String.valueOf(i));

        if(i==1)
        {
         tvVideos.setTextColor(getResources().getColor(R.color.theme));
            viewVideos.setBackgroundColor(getResources().getColor(R.color.theme));
            imageVideios.setBackground(getResources().getDrawable(R.drawable.select_video));

            tvImage.setTextColor(getResources().getColor(R.color.black));
            viewImgage.setBackgroundColor(getResources().getColor(R.color.white));
            imgeImge.setBackground(getResources().getDrawable(R.drawable.image));

            tvMilestoe.setTextColor(getResources().getColor(R.color.black));
            viewMilestone.setBackgroundColor(getResources().getColor(R.color.white));
            imageMilestone.setBackground(getResources().getDrawable(R.drawable.milestone));

        }
        else if(i==2)
        {
            tvVideos.setTextColor(getResources().getColor(R.color.black));
            viewVideos.setBackgroundColor(getResources().getColor(R.color.white));
            imageVideios.setBackground(getResources().getDrawable(R.drawable.video));

            tvImage.setTextColor(getResources().getColor(R.color.theme));
            viewImgage.setBackgroundColor(getResources().getColor(R.color.theme));
            imgeImge.setBackground(getResources().getDrawable(R.drawable.select_image));

            tvMilestoe.setTextColor(getResources().getColor(R.color.black));
            viewMilestone.setBackgroundColor(getResources().getColor(R.color.white));
            imageMilestone.setBackground(getResources().getDrawable(R.drawable.milestone));
        }
        else if(i==3)
        {
            tvVideos.setTextColor(getResources().getColor(R.color.black));
            viewVideos.setBackgroundColor(getResources().getColor(R.color.white));
            imageVideios.setBackground(getResources().getDrawable(R.drawable.video));

            tvImage.setTextColor(getResources().getColor(R.color.black));
            viewImgage.setBackgroundColor(getResources().getColor(R.color.white));
            imgeImge.setBackground(getResources().getDrawable(R.drawable.image));

            tvMilestoe.setTextColor(getResources().getColor(R.color.theme));
            viewMilestone.setBackgroundColor(getResources().getColor(R.color.theme));
            imageMilestone.setBackground(getResources().getDrawable(R.drawable.select_milestone));
        }
    }

}
