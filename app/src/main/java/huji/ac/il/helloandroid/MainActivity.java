package huji.ac.il.helloandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    EditText mTextInput;
    RecyclerView mChatContent;
    ConversationAdapter mAdapter;
    ImageView mSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextInput = (EditText) findViewById(R.id.text_input);
        mSend = (ImageView) findViewById(R.id.send);
        mTextInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEND) {
                    appendLine(v);
                    return true;
                }
                return false;
            }
        });
        mSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendLine(mTextInput);
            }
        });

        mChatContent = (RecyclerView) findViewById(R.id.conversation);
        mAdapter = new ConversationAdapter();
        mChatContent.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mChatContent.setAdapter(mAdapter);

    }

    private void appendLine(TextView v) {
        String content = v.getText().toString();
        long time = System.currentTimeMillis();
        mAdapter.addItem(time, content);
    }
}
