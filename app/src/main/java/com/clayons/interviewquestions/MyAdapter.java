package com.clayons.interviewquestions;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.clayons.interviewquestions.Model.Person;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by ojiofong on 3/7/17.
 *
 */


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<Person> persons = new ArrayList<>();
    private Context context;
    MainPresenterImpl presenter;

    MyAdapter(Context context) {
        this.context = context;
    }

    MyAdapter(Context context, MainPresenterImpl presenter) {
        this.context = context;
        this.presenter = presenter;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView nameTv;
        ImageView avatarIv;
        ImageView likeIv;

        ViewHolder(View rootItemView) {
            super(rootItemView);
            nameTv = (TextView) rootItemView.findViewById(R.id.name);
            avatarIv = (ImageView) rootItemView.findViewById(R.id.ivAvatarPerson);
            likeIv = (ImageView) rootItemView.findViewById(R.id.ivIsLiked);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final Person person = persons.get(position);
        String name = String.format(Locale.US, "%s %s", person.firstName, person.lastName);
        holder.nameTv.setText(name);
        holder.likeIv.setImageResource(person.isLiked ? R.drawable.ic_heart_filled : R.drawable.ic_heart_outline);
        Picasso.with(context).load(person.photoUrl).into(holder.avatarIv);


        holder.likeIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Not persisting this on disk for simplicity.
                // State is tied to activity lifecycle
                person.isLiked = !person.isLiked;
                notifyDataSetChanged();
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onItemClicked(position, person);
            }
        });

    }

    @Override
    public int getItemCount() {
        return persons.size();
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.item_person_summary;
    }
}