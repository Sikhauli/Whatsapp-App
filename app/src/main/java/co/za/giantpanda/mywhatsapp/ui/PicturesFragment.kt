package co.za.giantpanda.mywhatsapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import co.za.giantpanda.mywhatsapp.R
import android.widget.RelativeLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetBehavior

class PicturesFragment : Fragment() {

  private var sheetBehavior: BottomSheetBehavior<*>? = null
  private var bottomSheet: RelativeLayout? = null
  private var peekRecyclerView: RecyclerView? = null
  private var MainRecyclerView:RecyclerView? = null
  private var peekView: RelativeLayout? = null
  private var collapsedView:RelativeLayout? = null
 // private lateinit var bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout>


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    bottomSheet = (view)?.findViewById((R.id.bottom_sheet))
   // sheetBehavior = BottomSheetBehavior.from(bottomSheet)
    peekView = (view)?.findViewById((R.id.peekView));
    collapsedView = (view)?.findViewById(R.id.collapsedView)
    peekRecyclerView = (view)?.findViewById(R.id.peekRecyclerView);
    MainRecyclerView = (view)?.findViewById(R.id.MainRecyclerView);

//    peekRecyclerView?.setLayoutManager(...
//    peekRecyclerView?.setAdapter(...
//    MainRecyclerView?.setLayoutManager(...
//    MainRecyclerView?.setAdapter(...

  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?): View? {
    return inflater.inflate(R.layout.fragment_pictures, container, false)
  }



}