package com.example.riyad.mycronometer;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * Created by riyad on 22/09/2016.
 */
public class HelloIntentService extends IntentService {
    public HelloIntentService(){
        super("NomeDaThreadAqui");
    }

    private static final int MAX = 30;
    private static final String TAG = "livro";
    private boolean running;

    @Override
    protected void onHandleIntent(Intent intent){
        running = true;
        //Este metodo executa em uma thread
        //Quando ele terminar, o metodo stopSelf() sera chamado automaticamente
        int count = 0;
        while (running && count < MAX){
            fazAlgumaCoisa();
            Log.d(TAG, "ExemploServico executando..." + count);
            count++;
        }
        Log.d(TAG, "ExemploServico fim.");
    }

    private void fazAlgumaCoisa(){
        try{
            //Simula algum processamento
            Thread.sleep(1000);
        }catch (InterruptedException e){
            Log.e(TAG, e.getMessage(), e);
        }
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        //Ao encerrar o servico, altera a flag para a thread parar
        running = false;
        Log.d(TAG, "ExemploServico.onDestroy()");
        notificacao("MyCronometer", "Fim do tempo!");
    }

    private void notificacao(String cTitle, String cText) {
        int id = 1;
        String contentTitle = cTitle;
        String contentText = cText;
        Intent intent = new Intent(this, MainActivity.class);
        NotificationUtil.create(this, intent, contentTitle, contentText, id);
    }
}
