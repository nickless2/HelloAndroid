package huji.ac.il.helloandroid;

import android.support.v4.util.Pair;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by thepoosh on 03/02/2017.
 */

public class ConversationAdapter extends RecyclerView.Adapter<ConversationAdapter.ConversationHolder> {
    private static final String TAG = "ConversationAdapter";
    List<Pair<Long, String>> mChatItems = new ArrayList<>();
    DateFormat FORMAT = new SimpleDateFormat("HH:mm", Locale.getDefault());

    @Override
    public ConversationHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View chatItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_item, parent, false);
        return new ConversationHolder(chatItem);
    }

    @Override
    public int getItemCount() {
        return mChatItems.size();
    }

    void addItem(long when, String what) {
        Pair<Long, String> item = new Pair<>(when, what);
        mChatItems.add(item);
        notifyItemInserted(mChatItems.size());
    }

    @Override
    public void onBindViewHolder(ConversationHolder holder, int position) {
        Pair<Long, String> currentItem = mChatItems.get(position);
        holder.timestamp.setText(FORMAT.format(currentItem.first));
        holder.content.setText(currentItem.second);
    }

    static class ConversationHolder extends RecyclerView.ViewHolder {
        TextView timestamp;
        TextView content;

        ConversationHolder(View itemView) {
            super(itemView);
            timestamp = (TextView) itemView.findViewById(R.id.timestamp);
            content = (TextView) itemView.findViewById(R.id.text);
        }
    }
}
