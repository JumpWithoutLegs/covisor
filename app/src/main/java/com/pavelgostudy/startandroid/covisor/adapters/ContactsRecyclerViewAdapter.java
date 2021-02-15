package com.pavelgostudy.startandroid.covisor.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pavelgostudy.startandroid.covisor.R;
import com.pavelgostudy.startandroid.covisor.model.spisconts.Data;

import java.util.List;

public class ContactsRecyclerViewAdapter extends RecyclerView.Adapter<ContactsRecyclerViewAdapter.ContactsViewHolder> {
    private List<Data> contacts;

    public ContactsRecyclerViewAdapter(List<Data> contacts) {
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public ContactsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.contacts_list_item, parent, false);
        return new ContactsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactsViewHolder holder, int position) {
        holder.contactName.setText(contacts.get(position).getFiocont());
        holder.contactStatus.setText(contacts.get(position).getStatus());
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public static class ContactsViewHolder extends RecyclerView.ViewHolder {
        TextView contactName;
        TextView contactStatus;

        public ContactsViewHolder(@NonNull View itemView) {
            super(itemView);
            contactName = itemView.findViewById(R.id.contact_name_text_view);
            contactStatus = itemView.findViewById(R.id.contact_status_text_view);
        }
    }
}
