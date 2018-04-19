package fr.eni.autoloc.autoloc.adapter;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import fr.eni.autoloc.autoloc.BO.Vehicule;
import fr.eni.autoloc.autoloc.R;
import fr.eni.autoloc.autoloc.activity.fragment.ParkingFragment.OnListFragmentInteractionListener;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Vehicule} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyParkingRecyclerViewAdapter extends RecyclerView.Adapter<MyParkingRecyclerViewAdapter.ViewHolder> {

    private final List<Vehicule> parking;
    private final OnListFragmentInteractionListener mListener;

    public MyParkingRecyclerViewAdapter(List<Vehicule> parking, OnListFragmentInteractionListener listener) {
        this.parking = parking;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_parking, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.vehicule = parking.get(position);
        holder.txtMarque.setText(parking.get(position).getModel().getMarque().getNom());
        holder.txtModele.setText(parking.get(position).getModel().getNom());
        holder.txtType.setText(parking.get(position).getModel().getType().getNom());
        holder.txtPuissance.setText(parking.get(position).getPuissance());
        holder.photo.setImageURI(Uri.parse(parking.get(position).getListPhotos().get(0).getPath()));

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.vehicule);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return parking.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView txtMarque;
        public final TextView txtModele;
        public final TextView txtType;
        public final TextView txtPuissance;
        public final ImageView photo;
        public Vehicule vehicule;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            txtMarque = (TextView) view.findViewById(R.id.txt_marque);
            txtModele = (TextView) view.findViewById(R.id.txt_modele);
            txtType = (TextView) view.findViewById(R.id.txt_type);
            txtPuissance = (TextView) view.findViewById(R.id.txt_puissance);
            photo = (ImageView) view.findViewById(R.id.photo);

        }

        @Override
        public String toString() {
            return super.toString() + " '" + txtMarque.getText() + " '"
                    + txtModele.getText() + " '"
                    + txtType.getText() + " '"
                    + txtPuissance.getText() + " '"
                    + photo.toString() + " '";
        }
    }
}
