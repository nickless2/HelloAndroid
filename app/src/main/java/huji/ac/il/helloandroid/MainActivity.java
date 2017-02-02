package huji.ac.il.helloandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    public static final int MAX_NUMBER_OF_CHARS = 140;
    private static final String TAG = "MainActivity";
    EditText mTextInput;
    TextView mChatContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextInput = (EditText) findViewById(R.id.text_input);
        mChatContent = (TextView) findViewById(R.id.conversation);

        mTextInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEND) {
                    StringBuilder currentChat = new StringBuilder(mChatContent.getText());
                    currentChat.append(v.getText()).append('\n');
                    mChatContent.setText(currentChat.toString());
                    mTextInput.setText("");
                    return true;
                }
                return false;
            }
        });
    }
}
