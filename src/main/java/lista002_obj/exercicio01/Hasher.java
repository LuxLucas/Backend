package lista002_obj.exercicio01;

import java.util.Random;

public class Hasher{
    private Random random = new Random();
    private int passwordLength;
    private static final String SYMBOLS_FOR_HASHING = "abcdefghijklmnopqrstuvwxyz" +
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
            "0123456789" +
            "!@#$%&*()_+-=[]{}|;':\",./<>?" +
            "áéíóúàèìòùâêîôûãõç" +
            "ÁÉÍÓÚÀÈÌÒÙÂÊÎÔÛÃÕÇ" +
            "\\`~^" +
            "çÇ";

    public Hasher(int passwordLength){
        setPasswordLenght(passwordLength);
    }

    private boolean passwordLengthIsValid(int passwordLength){
        return passwordLength > 0;
    }

    public void setPasswordLenght(int newPasswordLength) {
        if(!passwordLengthIsValid(newPasswordLength)){
            throw new IllegalArgumentException("Tamanho de para senha inválido...");
        }
        this.passwordLength = newPasswordLength;
    }

    private short[] createRandomNumbersEqualToThePasswordLength(){
        short[] randomNumbers = new short[8];
        for(short i = 0; i < 8; i++){
            randomNumbers[i] = (short) this.random.nextInt(0, SYMBOLS_FOR_HASHING.length());
        }
        return randomNumbers;
    }

    public String password(){

    }
}