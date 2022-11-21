package ss16.Bai_tap;

import ss16.Thuc_hanh.ReadAndWriteFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CopyFileText {
    public List<String> readFile(String filePath){
        List<String> str = new ArrayList<>();
        try {
            File file = new File(filePath);

            if (!file.exists()) throw new FileNotFoundException();

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = br.readLine()) != null) {
                str.add(line);
            }
            br.close();
        } catch (Exception e) {
            System.err.println("Fie không tồn tại or nội dung có lỗi!");
        }
        return str;
    }
    public int count(List<String> str){
        int count = 0;
        for (int i = 0; i < str.size(); i++) {
            String temp = str.get(i);
            for (int j = 0; j < temp.length(); j++) {
                count++;
            }
        }
        return count;
    }
    public void writeFile(String filePath, List<String> str){
        try {
            File writer = new File(filePath);

            if(writer.exists()) throw new FileNotFoundException();
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(writer));
            int count = count(str);
            for (int i = 0; i < str.size(); i++) {
                bufferedWriter.write(str.get(i));
            }
            bufferedWriter.write(" Số lượng phần tử là: " + count);

            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CopyFileText readAndWriteFile = new CopyFileText();
        List<String> str = readAndWriteFile.readFile("D:\\CodeGym\\Module_2\\src\\ss16\\Bai_tap\\source file.txt");
        readAndWriteFile.writeFile("D:\\CodeGym\\Module_2\\src\\ss16\\Bai_tap\\target file.txt",str);
    }
}
