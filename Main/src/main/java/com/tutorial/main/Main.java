package com.tutorial.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class loginPage implements ActionListener {
    JFrame frame = new JFrame("FORM LOGIN DAN REGISTER");
    JButton buttonLogin = new JButton("LOGIN");
    JButton buttonRegister = new JButton("REGISTER");
    JTextField kolomUsername = new JTextField();
    JPasswordField kolomPassword = new JPasswordField();
    String[] usernamePengguna = new String[999];
    String[] passwordPengguna = new String[999];

    loginPage(String[] usernameRegister, String[] passwordRegister){
        System.out.println("Akun Yang Tersedia: ");
        for(int i = 0 ; i < usernameRegister.length; i++){ // Memindahkan database
            this.usernamePengguna[i] = usernameRegister[i];
            this.passwordPengguna[i] = passwordRegister[i];
            if(usernamePengguna[i] == null){
                break;
            }
            System.out.println(i+1);
            System.out.println("Username: " + usernamePengguna[i]);
            System.out.println("Password: " + passwordPengguna[i]);
        }
        System.out.println(" ");
        // Membuat frame
        frame.setSize(600,400); // ukuran
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // agar saat di close program terhenti
        frame.setResizable(false); // agar ukuran tidak bisa dirubah
        frame.setLayout(null); // agar bisa mengatur posisi komponen
        frame.setLocationRelativeTo(null); // agar window ada di tengah
        frame.setVisible(true); // agar window bisa terlihat

        // Membuat Label
        JLabel judul = new JLabel();
        JLabel username = new JLabel();
        JLabel password = new JLabel();

        judul.setText("FORM LOGIN");
        judul.setFont(new Font("MV Boli", Font.PLAIN, 32)); // set font dan sejenisnya
        judul.setBounds(150, 20, 300, 50);

        username.setText("Username");
        username.setFont(new Font("MV Boli", Font.PLAIN, 16)); // set font dan sejenisnya
        username.setBounds(150, 90, 320, 50);
        kolomUsername.setBounds(150, 140, 320, 30 );
        kolomUsername.setFont(new Font("Consolas", Font.PLAIN, 24));

        password.setText("Password");
        password.setFont(new Font("MV Boli", Font.PLAIN, 16)); // set font dan sejenisnya
        password.setBounds(150, 170, 320, 50);
        kolomPassword.setBounds(150, 220, 320, 30 );
        kolomPassword.setFont(new Font("Consolas", Font.PLAIN, 24));

        // Membuat button
        buttonLogin.setBounds(150, 300, 150, 30);
        buttonLogin.setFont(new Font("MV Boli", Font.BOLD, 20));
        buttonLogin.setFocusable(false);
        buttonLogin.setBackground(Color.lightGray);
        buttonLogin.addActionListener(this);

        buttonRegister.setBounds(320, 300, 150, 30);
        buttonRegister.setFont(new Font("MV Boli", Font.BOLD, 20));
        buttonRegister.setFocusable(false);
        buttonRegister.setBackground(Color.lightGray);
        buttonRegister.addActionListener(this); // untuk menandakan aksi bisa dilakukan disini

        // Mengisi Frame Awal
        frame.getContentPane().setBackground(new Color(237, 221, 190));
        frame.add(buttonLogin);
        frame.add(buttonRegister);
        frame.add(judul);
        frame.add(username);
        frame.add(password);
        frame.add(kolomUsername);
        frame.add(kolomPassword);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==buttonRegister){
            frame.dispose();
            registerPage registerWindow = new registerPage(usernamePengguna, passwordPengguna);
            JOptionPane.showMessageDialog(null, "Silahkan Membuat Akun", "Pemberitahuan", JOptionPane.INFORMATION_MESSAGE);
        }
        if(e.getSource()==buttonLogin){
            System.out.println("Ini username yang dimasukkan: " + kolomUsername.getText());
            System.out.println("Ini password yang dimasukkan: " + kolomPassword.getText());
            System.out.println(" ");

            boolean correctUsername = false;
            boolean correctPassword = false;
            int indeksUser = 0;

            for(int i = 0 ; i < usernamePengguna.length; i++){
                if(kolomUsername.getText().equals(usernamePengguna[i])){
                    correctUsername = true;
                    indeksUser = i;
                    break;
                } else if(usernamePengguna[i] == null){
                    break;
                }
            }
            for(int i = 0 ; i < passwordPengguna.length; i++){
                if(kolomPassword.getText().equals(passwordPengguna[i])){
                    correctPassword = true;
                    break;
                } else if(passwordPengguna[i] == null){
                    break;
                }
            }

            if(kolomUsername.getText().equals("") || kolomPassword.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Username atau Password Tidak Boleh Kosong", "Pemberitahuan", JOptionPane.INFORMATION_MESSAGE);
            } else if(correctUsername && correctPassword){
                JOptionPane.showMessageDialog(null, "LOGIN BERHASIL!", "Pemberitahuan", JOptionPane.INFORMATION_MESSAGE);
                frame.dispose();
                mainPage mainWindow = new mainPage(usernamePengguna[indeksUser], usernamePengguna, passwordPengguna);
            } else{
                JOptionPane.showMessageDialog(null, "Username atau Password SALAH!", "Pemberitahuan", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}

class registerPage implements ActionListener {
    JFrame frame = new JFrame("FORM LOGIN DAN REGISTER");
    JButton button = new JButton("BUAT AKUN");
    JButton buttonKembali = new JButton("<--");
    JTextField kolomUsername = new JTextField();
    JPasswordField kolomPassword = new JPasswordField();
    JPasswordField kolomConfirm = new JPasswordField();
    String[] usernamePengguna = new String[999];
    String[] passwordPengguna = new String[999];

    registerPage(String[] prevUsername, String[] prevPassword){
        for(int i = 0 ; i < prevUsername.length; i++){ // memindahkan database ke lokal
            this.usernamePengguna[i] = prevUsername[i];
            this.passwordPengguna[i] = prevPassword[i];
        }
        // Membuat frame
        frame.setSize(600,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Membuat button
        button.setBounds(150, 300, 200, 30);
        button.setFont(new Font("MV Boli", Font.BOLD, 20));
        button.setFocusable(false);
        button.setBackground(Color.lightGray);
        button.addActionListener(this); // untuk menandakan aksi bisa dilakukan disini

        buttonKembali.setBounds(360, 300, 90, 30);
        buttonKembali.setFont(new Font("MV Boli", Font.BOLD, 20));
        buttonKembali.setFocusable(false);
        buttonKembali.setBackground(Color.lightGray);
        buttonKembali.addActionListener(this); // untuk menandakan aksi bisa dilakukan disini

        // Membuat Label
        JLabel judul = new JLabel();
        JLabel username = new JLabel();
        JLabel password = new JLabel();
        JLabel confirmPassword = new JLabel();

        judul.setText("FORM REGISTER");
        judul.setFont(new Font("MV Boli", Font.PLAIN, 32)); // set font dan sejenisnya
        judul.setBounds(150, 20, 300, 50);

        username.setText("Username");
        username.setFont(new Font("MV Boli", Font.PLAIN, 16)); // set font dan sejenisnya
        username.setBounds(150, 80, 300, 50);
        kolomUsername.setBounds(150, 120, 300, 30 );
        kolomUsername.setFont(new Font("Consolas", Font.PLAIN, 24));

        password.setText("Password");
        password.setFont(new Font("MV Boli", Font.PLAIN, 16)); // set font dan sejenisnya
        password.setBounds(150, 140, 300, 50);
        kolomPassword.setBounds(150, 180, 300, 30 );
        kolomPassword.setFont(new Font("Consolas", Font.PLAIN, 24));

        confirmPassword.setText("Confirm Password");
        confirmPassword.setFont(new Font("MV Boli", Font.PLAIN, 16)); // set font dan sejenisnya
        confirmPassword.setBounds(150, 200, 300, 50);
        kolomConfirm.setBounds(150, 240, 300, 30 );
        kolomConfirm.setFont(new Font("Consolas", Font.PLAIN, 24));

        // Mengisi Frame Awal
        frame.getContentPane().setBackground(new Color(237, 221, 190));
        frame.add(button);
        frame.add(buttonKembali);
        frame.add(judul);
        frame.add(username);
        frame.add(password);
        frame.add(confirmPassword);
        frame.add(kolomUsername);
        frame.add(kolomPassword);
        frame.add(kolomConfirm);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button){
            System.out.println("Ini username yang dimasukkan: " + kolomUsername.getText());
            System.out.println("Ini password yang dimasukkan: " + kolomPassword.getText());
            System.out.println("Ini confirm yang dimasukkan: " + kolomConfirm.getText());
            System.out.println(" ");
            // untuk mengecek agar username dan password tidak mengandung spasi
            boolean wrongUsername = false;
            boolean wrongPassword = false;
            String tempUsername = kolomUsername.getText();
            String tempPassword = kolomPassword.getText();
            for(int i = 0 ; i < tempUsername.length(); i++){
                if(tempUsername.charAt(i) == ' '){
                    wrongUsername = true;
                }
            }
            for(int i = 0 ; i < tempPassword.length(); i++){
                if(tempPassword.charAt(i) == ' '){
                    wrongPassword = true;
                }
            }

            // untuk mengecek apakah di database ada username yang sama
            boolean availableUsername = false;
            for(int i = 0 ; i < usernamePengguna.length; i++){
                if(usernamePengguna[i] == null){
                    break;
                }
                if(usernamePengguna[i].equals(tempUsername)){
                    availableUsername = true;
                    break;
                }
            }

            // jika ada kolom yang kosong
            if(kolomUsername.getText().equals("") || kolomPassword.getText().equals("") || kolomConfirm.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Username atau Password Tidak Boleh Kosong", "Pemberitahuan", JOptionPane.INFORMATION_MESSAGE);
            } else if(!kolomPassword.getText().equals(kolomConfirm.getText())){ // jika password dan confirm berbeda
                JOptionPane.showMessageDialog(null, "Password dan Konfirmasi BERBEDA!", "Pemberitahuan", JOptionPane.INFORMATION_MESSAGE);
            } else if(wrongUsername || wrongPassword){ // jika username atau password mengandung spasi
                JOptionPane.showMessageDialog(null, "Username atau Password Tidak Boleh Mengandung Spasi!", "Pemberitahuan", JOptionPane.INFORMATION_MESSAGE);
            } else if(availableUsername){ // jika username sudah pernah digunakan sebelumnya
                JOptionPane.showMessageDialog(null, "Username Sudah Digunakan!", "Pemberitahuan", JOptionPane.INFORMATION_MESSAGE);
            } else{
                for(int i = 0 ; i < usernamePengguna.length; i++){
                    if(usernamePengguna[i] == null){
                        this.usernamePengguna[i] = kolomUsername.getText(); // untuk mengeset nama pengguna
                        break;
                    }
                }
                for(int i = 0 ; i < passwordPengguna.length; i++){
                    if(passwordPengguna[i] == null){
                        this.passwordPengguna[i] = kolomPassword.getText(); // untuk mengeset nama pengguna
                        break;
                    }
                }
                frame.dispose(); // menghilangkan frame saat ini
                loginPage loginWindow = new loginPage(usernamePengguna, passwordPengguna); // memunculkan frame login kembali
                JOptionPane.showMessageDialog(null, "Akun Telah Berhasil Dibuat!", "Pemberitahuan", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        if(e.getSource()==buttonKembali){
            frame.dispose();
            loginPage loginWindow = new loginPage(usernamePengguna, passwordPengguna); // memunculkan frame login kembali
        }
    }
}

class mainPage implements ActionListener{
    JFrame frame = new JFrame("HALAMAN UTAMA");
    JButton buttonKembali = new JButton("Kembali");
    String[] usernamePengguna = new String[999];
    String[] passwordPengguna = new String[999];

    mainPage(String username, String[] usernameRegister, String[] passwordRegister){
        for(int i = 0 ; i < usernameRegister.length; i++){ // memindahkan database ke lokal
            this.usernamePengguna[i] = usernameRegister[i];
            this.passwordPengguna[i] = passwordRegister[i];
        }
        // Membuat frame
        frame.setSize(600,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Membuat Label
        JLabel greetings = new JLabel();
        JLabel navBar = new JLabel();
        JLabel isi = new JLabel();

        navBar.setOpaque(true);
        navBar.setBounds(0,0,600,50);
        navBar.setBackground(new Color(77, 68, 44));

        greetings.setText(username);
        greetings.setFont(new Font("Times New Roman", Font.PLAIN, 24)); // set font dan sejenisnya
        greetings.setBounds(10,10,300,30);
        greetings.setForeground(Color.white);

        isi.setText("Selamat datang, " + username);
        isi.setFont(new Font("MV Boli", Font.PLAIN, 18));
        isi.setBounds(10, 60, 300, 50);



        // Membuat Button
        buttonKembali.setBounds(10, 320, 120, 30);
        buttonKembali.setFont(new Font("MV Boli", Font.BOLD, 20));
        buttonKembali.setFocusable(false);
        buttonKembali.setBackground(Color.lightGray);
        buttonKembali.addActionListener(this); // untuk menandakan aksi bisa dilakukan disini

        // Mengisi Frame Awal
        frame.getContentPane().setBackground(new Color(237, 221, 190));
        frame.add(greetings);
        frame.add(navBar);
        frame.add(isi);
        frame.add(buttonKembali);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==buttonKembali){
            int masukan = JOptionPane.showConfirmDialog(null, "Apakah anda ingin logout?", "Permintaan Keluar", JOptionPane.YES_NO_OPTION);
            if(masukan == 0){
                frame.dispose();
                loginPage loginWindow = new loginPage(usernamePengguna, passwordPengguna);
                JOptionPane.showMessageDialog(null, "Anda Telah Berhasil Logout!", "Pemberitahuan", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        String[] dataUsername = new String[999];
        String[] dataPassword = new String[999];
        loginPage loginWindow = new loginPage(dataUsername, dataPassword);
    }
}
