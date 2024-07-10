//package com.rendy.login;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Toast;
//
//import androidx.activity.EdgeToEdge;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.graphics.Insets;
//import androidx.core.view.ViewCompat;
//import androidx.core.view.WindowInsetsCompat;
//
//import com.loopj.android.http.AsyncHttpClient;
//import com.loopj.android.http.AsyncHttpResponseHandler;
//
//import cz.msebera.android.httpclient.Header;
//
//public class MainActivity extends AppCompatActivity {
//
//    private Button _loginButton;
//    private EditText _idEditText;
//    private EditText _passwordEditText;
//    private Intent _menuIntent;
//    private String _id;
//    private String _password;
//    private String _url;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_main);
//
//        //ubah Disini
//        _idEditText = (EditText) findViewById(R.id.idEditText);
//        _loginButton = (Button) findViewById(R.id.loginbutton);
//        _passwordEditText = (EditText) findViewById(R.id.passwordEditText);
//
//        _loginButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                _id = _idEditText.getText().toString();
//                _password = _passwordEditText.getText().toString();
//                _url = "https://stmikpontianak.net/011100862/login.php?id=" + _id + "&password=" + _password;
//
//                AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
//
//                asyncHttpClient.get(_url, new AsyncHttpResponseHandler() {
//                    @Override
//                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
//                        String hasil = new String(responseBody);
//
//                        if (!hasil.equals("[{\"idCount\":\"1\"}]")){
//                            Toast.makeText(getApplicationContext(),"ID dan password anda tidak cocok.", Toast.LENGTH_SHORT).show();
//                            return;
//                        }
//
//                        Toast.makeText(getApplicationContext(), "Selamat Datang Tuan 👑," + _id , Toast.LENGTH_SHORT).show();
//                        _menuIntent = new Intent(getApplicationContext(), MenuActivity.class);
//                        startActivity(_menuIntent);
//
//                    }
//
//                    @Override
//                    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
//                        Toast.makeText(getApplicationContext(), error.getMessage(),Toast.LENGTH_SHORT).show();
//                    }
//                });
//            }
//        });
//
//    }
//}


//package com.rendy.login;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Toast;
//
//import androidx.activity.EdgeToEdge;
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.loopj.android.http.AsyncHttpClient;
//import com.loopj.android.http.AsyncHttpResponseHandler;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import cz.msebera.android.httpclient.Header;
//
//public class MainActivity extends AppCompatActivity {
//
//    private Button _loginButton;
//    private EditText _idEditText;
//    private EditText _passwordEditText;
//    private Intent _menuIntent;
//    private String _id;
//    private String _password;
//    private String _url;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_main);
//
//        // Inisialisasi elemen UI dari layout
//        _idEditText = findViewById(R.id.idEditText);
//        _loginButton = findViewById(R.id.loginbutton);
//        _passwordEditText = findViewById(R.id.passwordEditText);
//
//        // Menangani klik pada tombol Login
//        _loginButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Mendapatkan nilai dari EditText ID dan Password
//                _id = _idEditText.getText().toString();
//                _password = _passwordEditText.getText().toString();
//
//                // URL untuk mengakses API login dengan parameter ID dan Password
//                _url = "https://stmikpontianak.net/011100862/login.php?id=" + _id + "&password=" + _password;
//
//                // Membuat objek AsyncHttpClient untuk melakukan HTTP GET request
//                AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
//
//                asyncHttpClient.get(_url, new AsyncHttpResponseHandler() {
//                    @Override
//                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
//                        try {
//                            // Mengubah byte array response menjadi String
//                            String response = new String(responseBody);
//
//                            // Membuat JSONArray dari response JSON
//                            JSONArray jsonArray = new JSONArray(response);
//
//                            // Memeriksa jika array JSON memiliki elemen
//                            if (jsonArray.length() > 0) {
//                                // Mengambil objek JSON pertama dari array
//                                JSONObject jsonObject = jsonArray.getJSONObject(0);
//
//                                // Mengambil nilai dari key 'idCount' dalam objek JSON
//                                String idCount = jsonObject.getString("idCount");
//
//                                // Memeriksa jika idCount adalah '1', artinya login berhasil
//                                if (idCount.equals("1")) {
//                                    // Menampilkan pesan selamat datang
//                                    Toast.makeText(getApplicationContext(), "Selamat Datang Tuan 👑," + _id, Toast.LENGTH_SHORT).show();
//
//                                    // Membuat intent untuk berpindah ke MenuActivity
//                                    _menuIntent = new Intent(getApplicationContext(), MenuActivity.class);
//                                    startActivity(_menuIntent);
//                                } else {
//                                    // Menampilkan pesan jika ID dan password tidak cocok
//                                    Toast.makeText(getApplicationContext(), "ID dan password anda tidak cocok.", Toast.LENGTH_SHORT).show();
//                                }
//                            } else {
//                                // Menampilkan pesan jika array JSON kosong atau tidak valid
//                                Toast.makeText(getApplicationContext(), "ID dan password anda tidak cocok.", Toast.LENGTH_SHORT).show();
//                            }
//                        } catch (JSONException e) {
//                            // Menampilkan pesan jika terjadi kesalahan parsing JSON
//                            Toast.makeText(getApplicationContext(), "Error parsing JSON response", Toast.LENGTH_SHORT).show();
//                            e.printStackTrace();
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
//                        // Menampilkan pesan jika terjadi kegagalan koneksi atau request
//                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
//                    }
//                });
//            }
//        });
//    }
//}
package com.rendy.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    private Button _loginButton;
    private EditText _idEditText;
    private EditText _passwordEditText;
    private Intent _menuIntent;
    private String _id;
    private String _password;
    private String _url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        _idEditText = findViewById(R.id.idEditText);
        _loginButton = findViewById(R.id.loginbutton);
        _passwordEditText = findViewById(R.id.passwordEditText);

        _loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _id = _idEditText.getText().toString();
                _password = _passwordEditText.getText().toString();
                _url = "https://stmikpontianak.net/011100862/login.php?id=" + _id + "&password=" + _password;

                AsyncHttpClient asyncHttpClient = new AsyncHttpClient();

                asyncHttpClient.get(_url, new AsyncHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                        try {
                            String response = new String(responseBody);
                            JSONArray jsonArray = new JSONArray(response);

                            if (jsonArray.length() > 0) {
                                JSONObject jsonObject = jsonArray.getJSONObject(0);
                                String idCount = jsonObject.getString("idCount");

                                if (idCount.equals("1")) {
                                    Toast.makeText(getApplicationContext(), "Selamat Datang ," + _id , Toast.LENGTH_SHORT).show();

                                    _menuIntent = new Intent(getApplicationContext(), MenuActivity.class);
                                    startActivity(_menuIntent);
                                } else {
                                    Toast.makeText(getApplicationContext(), "ID dan password anda tidak cocok.", Toast.LENGTH_SHORT).show();
                                }
                            }
                        } catch (JSONException e) {
                            Toast.makeText(getApplicationContext(), "Error parsing JSON response", Toast.LENGTH_SHORT).show();
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
