package fr.eni.autoloc.autoloc.activity.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import fr.eni.autoloc.autoloc.BO.Vehicule;
import fr.eni.autoloc.autoloc.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DetailFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public DetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DetailFragment newInstance(String param1, String param2) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public void setContent(Vehicule vehicule) {
        TextView immatriculation = getView().findViewById(R.id.txt_immatriculation);
        TextView marque = getView().findViewById(R.id.txt_marque);
        TextView modele = getView().findViewById(R.id.txt_modele);
        TextView type = getView().findViewById(R.id.txt_type);
        TextView puissance = getView().findViewById(R.id.txt_puissance);
        TextView etat = getView().findViewById(R.id.txt_etat);
        TextView disponibilite = getView().findViewById(R.id.txt_disponibilite);
        ImageView photo = getView().findViewById(R.id.photo);

        immatriculation.setText(vehicule.getImmatriculation);
        marque.setText(vehicule.getModel().getMarque().getNom());
        modele.setText(vehicule.getModel().getNom());
        type.setText(vehicule.getModel().getType().getNom());
        puissance.setText(vehicule.getPuissance());
        etat.setText(vehicule.getEtatVehicule().getNom());
        if (vehicule.getDisponibilite()) {
            disponibilite.setText(R.string.disponible);
            disponibilite.setBackgroundColor(getResources().getColor(R.color.colorDispo));
        }
        else {
            disponibilite.setText(R.string.indisponible);
            disponibilite.setBackgroundColor(getResources().getColor(R.color.colorIndispo));
        }
        photo.setImageURI(Uri.parse(vehicule.getListPhotos().get(0).getPath()));
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
