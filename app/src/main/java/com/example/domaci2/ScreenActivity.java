package com.example.domaci2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class ScreenActivity extends AppCompatActivity {


    private TextView welcomeText;
    private TextView mainText;
    private ImageView star;
    private Button favButton;
    private boolean favourite;
    private ImageButton aaa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen);

        init();
    }
    public void init(){
        favourite = false;
        initViews();
        initListeners();
    }


    @SuppressLint("SetTextI18n")
    public void initViews(){
        SharedPreferences sharedPreferences = getSharedPreferences(getPackageName(), Context.MODE_PRIVATE);
        String username = sharedPreferences.getString(LoginActivity.REG_NAME_KEY,"");

        welcomeText = findViewById(R.id.welcomeText);
        welcomeText.setText("Welcome " + username + " heres and article of the day, do you like it>");

        mainText = findViewById(R.id.mainText);
        mainText.setText(getArticle());

        favButton = findViewById(R.id.buttonFav);
        favButton.setText(R.string.favourite);
        star = findViewById(R.id.star);

    }
//@android:drawable/star_big_off
    public void initListeners(){
        favButton.setOnClickListener(v -> {
            if (!favourite){
//                star.setImageResource(R.drawable.logo);

                favButton.setText(R.string.unfavourite);
                favourite = true;
                aaa.setActivated(true);

            }
            else {
//                star.setImageResource(R.drawable.outline_star_outline_24);
                favButton.setText(R.string.favourite);
                favourite = false;
            }
        });

    }


    private String getArticle(){
        return "What is Lorem Ipsum?\n" +
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been " +
                "the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type " +
                "and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic " +
                "typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem " +
                "Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\n" +
                "\n" +
                "Why do we use it?\n" +
                "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. " +
                "The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, " +
                "content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as " +
                "their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have " +
                "evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).\n" +
                "\n" +
                "\n" +
                "Where does it come from?\n" +
                "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, " +
                "making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more " +
                "obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered " +
                "the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) " +
                "by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem " +
                "Ipsum, \"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32.\n" +
                "\n" +
                "The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. Sections 1.10.32 and 1.10.33 from \"de Finibus " +
                "Bonorum et Malorum\" by Cicero are also reproduced in their exact original form, accompanied by English versions from the 1914 translation by H. Rackham.\n" +
                "\n" +
                "Where can I get some?\n" +
                "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, " +
                "or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't " +
                "anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, " +
                "making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures," +
                " to generate Lorem Ipsum which looks reasonable. The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc.";
    }
}