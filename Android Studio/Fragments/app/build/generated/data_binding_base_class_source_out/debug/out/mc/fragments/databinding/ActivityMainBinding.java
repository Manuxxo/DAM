// Generated by view binder compiler. Do not edit!
package mc.fragments.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import mc.fragments.R;

public final class ActivityMainBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final FragmentContainerView contenedorAbajo;

  @NonNull
  public final FragmentContainerView contenedorArriba;

  private ActivityMainBinding(@NonNull LinearLayout rootView,
      @NonNull FragmentContainerView contenedorAbajo,
      @NonNull FragmentContainerView contenedorArriba) {
    this.rootView = rootView;
    this.contenedorAbajo = contenedorAbajo;
    this.contenedorArriba = contenedorArriba;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_main, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMainBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.contenedor_abajo;
      FragmentContainerView contenedorAbajo = ViewBindings.findChildViewById(rootView, id);
      if (contenedorAbajo == null) {
        break missingId;
      }

      id = R.id.contenedor_arriba;
      FragmentContainerView contenedorArriba = ViewBindings.findChildViewById(rootView, id);
      if (contenedorArriba == null) {
        break missingId;
      }

      return new ActivityMainBinding((LinearLayout) rootView, contenedorAbajo, contenedorArriba);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
