// Generated by view binder compiler. Do not edit!
package mc.fragments.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import mc.fragments.R;

public final class FragmentCalculoBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button boton;

  @NonNull
  public final TextView txtOperacion;

  @NonNull
  public final EditText txtResultado;

  private FragmentCalculoBinding(@NonNull ConstraintLayout rootView, @NonNull Button boton,
      @NonNull TextView txtOperacion, @NonNull EditText txtResultado) {
    this.rootView = rootView;
    this.boton = boton;
    this.txtOperacion = txtOperacion;
    this.txtResultado = txtResultado;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentCalculoBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentCalculoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_calculo, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentCalculoBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.boton;
      Button boton = ViewBindings.findChildViewById(rootView, id);
      if (boton == null) {
        break missingId;
      }

      id = R.id.txtOperacion;
      TextView txtOperacion = ViewBindings.findChildViewById(rootView, id);
      if (txtOperacion == null) {
        break missingId;
      }

      id = R.id.txtResultado;
      EditText txtResultado = ViewBindings.findChildViewById(rootView, id);
      if (txtResultado == null) {
        break missingId;
      }

      return new FragmentCalculoBinding((ConstraintLayout) rootView, boton, txtOperacion,
          txtResultado);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
