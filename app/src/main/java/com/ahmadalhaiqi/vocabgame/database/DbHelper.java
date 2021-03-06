package com.ahmadalhaiqi.vocabgame.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import static com.ahmadalhaiqi.vocabgame.database.Schema.*;

public class DbHelper extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "VocabGame.db";

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Words.SQL_CREATE_WORDS);

        // insert some words in the Words table
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('I', 'Saya', 'Basic', 'Pronoun');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('go', 'Pergi', 'Basic', 'Verb');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('come', 'Datang', 'Basic', 'Verb');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('went', 'Pergi', 'Basic', 'Verb');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('up', 'Up', 'Basic', 'Preposition');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('you', 'Anda', 'Basic', 'Pronoun');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('day', 'Hari', 'Basic', 'Noun');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('was', 'Adalah', 'Basic', 'Verb');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('look', 'Lihat', 'Basic', 'Verb');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('are', 'Adalah', 'Basic', 'Verb');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('the', 'Yang', 'Basic', 'Determiner');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('of', 'Daripada', 'Basic', 'Conjunction');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('we', 'Kami', 'Basic', 'Pronoun');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('this', 'Ini', 'Basic', 'Pronoun');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('dog', 'Anjing', 'Basic', 'Animals');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('me', 'Saya', 'Basic', 'Pronoun');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('like', 'Seperti', 'Basic', 'Verb');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('going', 'Pergi', 'Basic', 'Verb');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('big', 'besar', 'Basic', 'Adjective');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('she', 'Dia', 'Basic', 'Pronoun');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('and', 'Dan', 'Basic', 'Conjunction');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('they', 'Mereka', 'Basic', 'Pronoun');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('my', 'Saya', 'Basic', 'Pronoun');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('see', 'Lihat', 'Basic', 'Verb');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('on', 'Pada', 'Basic', 'Preposition');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('away', 'Jauh', 'Basic', 'Adverb');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('mother', 'Ibu', 'Basic', 'People');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('it', 'Ia', 'Basic', 'Pronoun');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('at', 'Pada', 'Basic', 'Preposition');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('play', 'Bermain', 'Basic', 'Verb');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('no', 'Tidak', 'Basic', 'Interjections');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('yes', 'Ya', 'Basic', 'Interjections');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('for', 'Untuk', 'Basic', 'Preposition');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('a', 'A', 'Basic', 'Determiner');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('father', 'Bapa', 'Basic', 'People');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('can', 'Boleh', 'Basic', 'Verb');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('he', 'Dia', 'Basic', 'Pronoun');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('am', 'Am', 'Basic', 'Verb');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('all', 'semua', 'Basic', 'Determiner');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('is', 'Adalah', 'Basic', 'Verb');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('cat', 'Kucing', 'Basic', 'Animals');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('get', 'Dapatkan', 'Basic', 'Verb');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('said', 'Kata', 'Basic', 'Verb');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('to', 'Kepada', 'Basic', 'Preposition');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('in', 'Dalam', 'Basic', 'Preposition');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('about', 'Kira-kira', 'Basic', 'Preposition');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('after', 'Selepas', 'Basic', 'Preposition');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('again', 'semula', 'Basic', 'Adverb');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('an', 'A', 'Basic', 'Determiner');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('another', 'Lain', 'Basic', 'Determiner');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('as', 'Sebagai', 'Basic', 'Conjunction');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('back', 'Belakang', 'Basic', 'Adverb');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('ball', 'Bola', 'Basic', 'Noun');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('be', 'Menjadi', 'Basic', 'Verb');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('because', 'Kerana', 'Basic', 'Conjunction');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('bed', 'Katil', 'Basic', 'Noun');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('been', 'Sudah', 'Basic', 'Verb');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('boy', 'Budak lelaki', 'Basic', 'People');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('brother', 'Saudara lelaki', 'Basic', 'People');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('but', 'Tetapi', 'Basic', 'Preposition');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('by', 'Oleh', 'Basic', 'Preposition');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('call', 'Panggilan', 'Basic', 'Verb');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('came', 'Datang', 'Basic', 'Verb');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('cannot', 'Tidak boleh', 'Basic', 'Verb');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('could', 'Boleh', 'Basic', 'Verb');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('did', 'Lakukan', 'Basic', 'Verb');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('do', 'Buat', 'Basic', 'Verb');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('do not', 'Jangan', 'Basic', 'Verb');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('dig', 'Menggali', 'Basic', 'Verb');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('door', 'Pintu', 'Basic', 'Noun');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('down', 'Turun', 'Basic', 'Preposition');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('first', 'Pertama', 'Basic', 'Adverb');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('from', 'Dari', 'Basic', 'Preposition');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('girl', 'Gadis', 'Basic', 'People');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('good', 'baik', 'Basic', 'Adjective');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('got', 'Mendapat', 'Basic', 'Verb');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('had', 'Telah', 'Basic', 'Verb');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('half', 'separuh', 'Basic', 'Determiner');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('has', 'Mempunyai', 'Basic', 'Verb');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('have', 'Mempunyai', 'Basic', 'Verb');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('help', 'bantu', 'Basic', 'Verb');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('her', 'Dia', 'Basic', 'Pronoun');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('here', 'Di sini', 'Basic', 'Adverb');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('him', 'Dia', 'Basic', 'Pronoun');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('his', 'Nya', 'Basic', 'Pronoun');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('home', 'Rumah', 'Basic', 'Noun');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('house', 'rumah', 'Basic', 'Noun');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('how', 'Bagaimana', 'Basic', 'Adverb');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('if', 'Jika', 'Basic', 'Conjunction');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('jump', 'Melompat', 'Basic', 'Verb');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('just', 'Hanya', 'Basic', 'Adverb');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('last', 'Lepas', 'Basic', 'Adverb');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('laugh', 'Ketawa', 'Basic', 'Verb');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('little', 'Sedikit', 'Basic', 'Determiner');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('live', 'Hidup', 'Basic', 'Verb');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('love', 'Cinta', 'Basic', 'Verb');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('made', 'dibuat', 'Basic', 'Verb');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('make', 'Buat', 'Basic', 'Verb');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('man', 'Lelaki', 'Basic', 'People');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('many', 'Ramai', 'Basic', 'Determiner');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('may', 'mungkin', 'Basic', 'Verb');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('more', 'Lebih lagi', 'Basic', 'Adverb');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('much', 'Banyak', 'Basic', 'Determiner');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('must', 'Mestilah', 'Basic', 'Verb');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('name', 'Nama', 'Basic', 'Noun');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('new', 'baru', 'Basic', 'Adjective');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('next', 'Seterusnya', 'Basic', 'Adjective');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('night', 'Malam', 'Basic', 'Time');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('not', 'Tidak', 'Basic', 'Adverb');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('now', 'Sekarang', 'Basic', 'Adverb');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('off', 'Off', 'Basic', 'Preposition');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('old', 'tua', 'Basic', 'Adjective');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('once', 'Sekali', 'Basic', 'Adverb');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('one', 'Satu', 'Basic', 'Numbers');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('or', 'Atau', 'Basic', 'Conjunction');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('our', 'Kami', 'Basic', 'Pronoun');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('out', 'keluar', 'Basic', 'Adverb');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('over', 'Lebih', 'Basic', 'Preposition');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('people', 'Orang', 'Basic', 'Noun');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('push', 'Tolak', 'Basic', 'Verb');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('pull', 'Tarik', 'Basic', 'Verb');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('put', 'letak', 'Basic', 'Verb');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('ran', 'Berlari', 'Basic', 'Verb');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('saw', 'Melihat', 'Basic', 'Verb');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('school', 'Sekolah', 'Basic', 'Noun');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('seen', 'Dilihat', 'Basic', 'Verb');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('should', 'Sepatutnya', 'Basic', 'Verb');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('sister', 'Kakak', 'Basic', 'People');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('so', 'Jadi', 'Basic', 'Conjunction');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('some', 'beberapa', 'Basic', 'Determiner');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('take', 'Ambil', 'Basic', 'Verb');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('than', 'Daripada', 'Basic', 'Conjunction');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('that', 'Itu', 'Basic', 'Pronoun');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('their', 'Mereka', 'Basic', 'Pronoun');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('them', 'mereka', 'Basic', 'Pronoun');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('then', 'Kemudian', 'Basic', 'Adverb');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('there', 'Di sana', 'Basic', 'Adverb');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('these', 'Ini', 'Basic', 'Pronoun');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('three', 'Tiga', 'Basic', 'Numbers');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('time', 'masa', 'Basic', 'Noun');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('too', 'Juga', 'Basic', 'Adverb');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('took', 'Mengambil', 'Basic', 'Verb');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('tree', 'Pokok', 'Basic', 'Noun');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('two', 'Dua', 'Basic', 'Numbers');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('us', 'Kami', 'Basic', 'Pronoun');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('very', 'Sangat', 'Basic', 'Adverb');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('want', 'Mahu', 'Basic', 'Verb');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('water', 'Air', 'Basic', 'Noun');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('way', 'Cara', 'Basic', 'Noun');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('were', 'Adalah', 'Basic', 'Verb');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('what', 'apa', 'Basic', 'Pronoun');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('when', 'bila', 'Basic', 'Conjunction');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('where', 'Di mana', 'Basic', 'Conjunction');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('who', 'Yang', 'Basic', 'Pronoun');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('will', 'Akan', 'Basic', 'Verb');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('with', 'Dengan', 'Basic', 'Preposition');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('would', 'Akan', 'Basic', 'Verb');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('your', 'Anda', 'Basic', 'Pronoun');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('red', 'Merah', 'Basic', 'Colors');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('green', 'Hijau', 'Basic', 'Colors');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('blue', 'Biru', 'Basic', 'Colors');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('yellow', 'kuning', 'Basic', 'Colors');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('black', 'Hitam', 'Basic', 'Colors');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('white', 'Putih', 'Basic', 'Colors');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('orange', 'Oren', 'Basic', 'Colors');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('brown', 'Coklat', 'Basic', 'Colors');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('gray', 'Kelabu', 'Basic', 'Colors');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('four', 'Empat', 'Basic', 'Numbers');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('five', 'Lima', 'Basic', 'Numbers');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('six', 'enam', 'Basic', 'Numbers');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('seven', 'Tujuh', 'Basic', 'Numbers');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('eight', 'Lapan', 'Basic', 'Numbers');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('nine', 'Sembilan', 'Basic', 'Numbers');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('ten', 'Sepuluh', 'Basic', 'Numbers');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('eleven', 'Sebelas', 'Basic', 'Numbers');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('twelve', 'Dua belas', 'Basic', 'Numbers');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('thirteen', 'tiga belas', 'Basic', 'Numbers');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('forteen', 'Belas', 'Basic', 'Numbers');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('fifteen', 'lima belas', 'Basic', 'Numbers');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('sixteen', 'Enam belas tahun', 'Basic', 'Numbers');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('seventeen', 'Tujuh belas tahun', 'Basic', 'Numbers');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('eighteen', 'Lapan belas', 'Basic', 'Numbers');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('nineteen', 'Sembilan belas', 'Basic', 'Numbers');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('twenty', 'Dua puluh', 'Basic', 'Numbers');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('Friday', 'Jumaat', 'Basic', 'Dayes');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('Saturday', 'Sabtu', 'Basic', 'Dayes');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('Sunday', 'Ahad', 'Basic', 'Dayes');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('Monday', 'Isnin', 'Basic', 'Dayes');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('Tuesday', 'Selasa', 'Basic', 'Dayes');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('Wednesday', 'Rabu', 'Basic', 'Dayes');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('Thursday', 'Khamis', 'Basic', 'Dayes');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('January', 'Januari', 'Basic', 'Months');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('February', 'Februari', 'Basic', 'Months');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('March', 'Mac', 'Basic', 'Months');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('April', 'April', 'Basic', 'Months');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('May', 'Mungkin', 'Basic', 'Months');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('June', 'Jun', 'Basic', 'Months');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('July', 'Julai', 'Basic', 'Months');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('August', 'Ogos', 'Basic', 'Months');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('September', 'September', 'Basic', 'Months');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('October', 'Oktober', 'Basic', 'Months');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('November', 'November', 'Basic', 'Months');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('December', 'Disember', 'Basic', 'Months');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('car', 'Kereta', 'Basic', 'Noun');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('pen', 'Pen', 'Basic', 'Noun');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('book', 'Buku', 'Basic', 'Noun');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('table', 'Jadual', 'Basic', 'Noun');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('chair', 'Kerusi', 'Basic', 'Noun');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('hospital', 'Hospital', 'Basic', 'Noun');");
        db.execSQL("INSERT INTO Words (english, melayu, level, category) VALUES ('road', 'Jalan raya', 'Basic', 'Noun');");

        db.execSQL(Scores.SQL_CREATE_SCORES);
        db.execSQL(Mistakes.SQL_CREATE_MISTAKES);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(Words.SQL_DELETE_WORDS);
        db.execSQL(Scores.SQL_DELETE_SCORES);
        db.execSQL(Mistakes.SQL_DELETE_MISTAKES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}

