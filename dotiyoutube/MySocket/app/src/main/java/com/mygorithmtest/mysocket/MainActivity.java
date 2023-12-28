package com.mygorithmtest.mysocket;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

//네트워킹 소켓을 위해는 스레드를 사용해야하고 네트워크 연결 필요
// 스레드를 위해서는 핸들러 사용
public class MainActivity extends AppCompatActivity {

    EditText input1;
    TextView output1;

    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input1 = findViewById(R.id.input1);
        output1 = findViewById(R.id.output1);

        Button send = findViewById(R.id.sendbutton);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String data = input1.getText().toString();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Log.d("readline", "linet");
                        try {
                            sending(data);
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();


            }

        });

        Button startServerButton = findViewById(R.id.startServerButton);
        startServerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        startServer();
                    }
                }).start();

            }
        });
    }

    public void startServer(){
        int port = 5001;
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            while (true) {
                Socket sock = serverSocket.accept();
                InetAddress clientHost = sock.getLocalAddress();
                int clientPort = sock.getPort();
                println("클라이언트 연결됨 : "+ clientHost + ", " + clientPort);

                ObjectInputStream inputStream = new ObjectInputStream(sock.getInputStream());
                String input = (String) inputStream.readObject();
                println("데이터 받음 : "+ input);

                ObjectOutputStream outputStream =  new ObjectOutputStream(sock.getOutputStream());
                outputStream.writeObject(input+" from server.");
                outputStream.flush();
                println("데이터 보냄 ");
                sock.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void println(String data) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                output1.append(data+"\n");
            }
        });


    }



    public void sending(String data) throws IOException, ClassNotFoundException {
        int port = 5001;
        Socket socket = new Socket("localhost", port);
        ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
        outputStream.writeObject(data);
        outputStream.flush();

        ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
        String input = (String) inputStream.readObject();
        socket.close();
//        Toast.makeText(this, input, Toast.LENGTH_SHORT).show();
    }
}