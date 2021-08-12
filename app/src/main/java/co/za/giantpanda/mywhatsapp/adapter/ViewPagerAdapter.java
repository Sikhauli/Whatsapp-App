package co.za.giantpanda.mywhatsapp.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import co.za.giantpanda.mywhatsapp.ui.CallsFragment;
import co.za.giantpanda.mywhatsapp.ui.MainFragment;
import co.za.giantpanda.mywhatsapp.ui.PicturesFragment;
import co.za.giantpanda.mywhatsapp.ui.StatusFragment;
import org.jetbrains.annotations.NotNull;

public class ViewPagerAdapter extends FragmentPagerAdapter {

  int totalTabs;

    public ViewPagerAdapter(FragmentManager fm, int totalTabs) {
      super(fm);
      this.totalTabs = totalTabs;
    }

    @NotNull @Override
    public Fragment getItem(int position) {
      switch (position) {
        case 0:
          return new PicturesFragment();
        case 1:
          return new MainFragment();
        case 2:
          return new StatusFragment();
        case 3:
          return new CallsFragment();
        default:
          return null;
      }
    }
    @Override
    public int getCount() {
      return totalTabs;
    }
  }