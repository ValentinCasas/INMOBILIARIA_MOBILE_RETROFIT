package com.example.inmobiliaria_android_mobile.ui.contratos;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.inmobiliaria_android_mobile.R;;
import com.example.inmobiliaria_android_mobile.databinding.FragmentDetalleContratoBinding;
import com.example.inmobiliaria_android_mobile.modelo.Contrato;
import com.example.inmobiliaria_android_mobile.modelo.Inmueble;
import com.example.inmobiliaria_android_mobile.modelo.Inquilino;
import com.example.inmobiliaria_android_mobile.modelo.Pago;
import com.example.inmobiliaria_android_mobile.request.ApiClient;

import java.util.ArrayList;


public class DetalleContratoFragment extends Fragment {

    private FragmentDetalleContratoBinding binding;
    private Inmueble inmueble;
    private DetalleContratoViewModel mv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentDetalleContratoBinding.inflate(getLayoutInflater());
        mv = new ViewModelProvider(this).get(DetalleContratoViewModel.class);
        View root = binding.getRoot();


        Bundle bundle = getArguments();
        inmueble = (Inmueble) bundle.getSerializable("inmueble");

        mv.obtenerContrato(inmueble);

        mv.getContratoMutable().observe(getViewLifecycleOwner(), new Observer<Contrato>() {
            @Override
            public void onChanged(Contrato contrato) {

                Inquilino inquilino = contrato.getInquilino();
                Inmueble inmueble = contrato.getInmueble();

                binding.tvCodigo.setText(String.valueOf(contrato.getId()));
                binding.tvMontoMensual.setText(String.valueOf(contrato.getMontoAlquilerMensual()));
                binding.tvFechaInicio.setText(contrato.getFechaInicio());
                binding.tvFechaFinalizacion.setText(contrato.getFechaFinalizacion());
                binding.tvInquilino.setText(inquilino.getNombre());
                binding.tvInmueble.setText(inmueble.getDireccion());
                binding.btnPagos.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mv.obtenerPagosPorContrato(contrato.getId());
                        mv.getPagosMutable().observe(getViewLifecycleOwner(), new Observer<ArrayList<Pago>>() {
                            @Override
                            public void onChanged(ArrayList<Pago> pagos) {
                                NavController navController = Navigation.findNavController(v);
                                Bundle bundle = new Bundle();
                                bundle.putSerializable("pagosAsociados", pagos);
                                navController.navigate(R.id.nav_detallePagosFragment, bundle);
                            }
                        });
                    }
                });


            }
        });


        return root;
    }


}