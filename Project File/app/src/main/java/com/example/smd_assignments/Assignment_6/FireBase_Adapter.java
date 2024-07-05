package com.example.smd_assignments.Assignment_6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smd_assignments.R;

import java.util.ArrayList;

public class FireBase_Adapter extends RecyclerView.Adapter<FireBase_Adapter.ViewHolder>{
    ArrayList<Students> studentArrayList;
    Context context;

    public FireBase_Adapter(ArrayList<Students> studentArrayList, Context context) {
        this.studentArrayList = studentArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.name.setText(studentArrayList.get(position).getName());
            holder.dept.setText(studentArrayList.get(position).getDept());
            holder.cgpa.setText(studentArrayList.get(position).getCgpa());
    }

    @Override
    public int getItemCount() {
        return studentArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView name, dept, cgpa;

        public ViewHolder(@NonNull View view) {
            super(view);
            name = view.findViewById(R.id.firebasename);
            dept = view.findViewById(R.id.firebasedept);
            cgpa = view.findViewById(R.id.firebasecgpa);
        }
    }
}
