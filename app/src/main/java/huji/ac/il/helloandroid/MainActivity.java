package huji.ac.il.helloandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    EditText mTextInput;
    TextView mChatContent;
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

        mChatContent = (TextView) findViewById(R.id.conversation);


    }

    private void appendLine(TextView v) {
        StringBuilder currentChat = new StringBuilder(mChatContent.getText());
        currentChat.append(v.getText()).append('\n');
        mChatContent.setText(currentChat.toString());
        mTextInput.setText("");
    }
}
