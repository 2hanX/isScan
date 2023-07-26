package com.example.isscan.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.util.Map;
import java.util.TreeMap;

public class RevShell {

    @FXML
    public ChoiceBox<String> choice_type;
    public Text genListener;
    public TextField port;
    public TextField ip;

    public String getIP(){
        return ip.getText();
    }

    public void initialize(){
        Map<String, String> choiceTypes = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        choiceTypes.put("nc", "nc -lvnp {port}");
        choiceTypes.put("nc freebsd", "nc -lvn {port}");
        choiceTypes.put("busybox nc", "busybox nc -lp {port}");
        choiceTypes.put("ncat", "ncat -lvnp {port}");
        choiceTypes.put("ncat.exe", "ncat.exe -lvnp {port}");
        choiceTypes.put("ncat (TLS)", "ncat --ssl -lvnp {port}");
        choiceTypes.put("rlwrap + nc", "rlwrap -cAr nc -lvnp {port}");
        choiceTypes.put("rustcat", "rcat -lp {port}");
        choiceTypes.put("rustcat + Command History", "rcat -lHp {port}");
        choiceTypes.put("pwncat", "python3 -m pwncat -lp {port}");
        choiceTypes.put("windows ConPty", "stty raw -echo; (stty size; cat) | nc -lvnp {port}");
        choiceTypes.put("socat", "socat -d -d TCP-LISTEN:{port} STDOUT");
        choiceTypes.put("socat (TTY)", "socat -d -d file:`tty`,raw,echo=0 TCP-LISTEN:{port}");
        choiceTypes.put("powercat", "powercat -l -p {port}");
        choiceTypes.put("msfconsole", "msfconsole -q -x \"use multi/handler; set payload {payload}; set lhost {ip}; set lport {port}; exploit\"");
        choiceTypes.put("hoaxshell", "python3 -c \"$(curl -s https://raw.githubusercontent.com/t3l3machus/hoaxshell/main/revshells/hoaxshell-listener.py)\" -t {type} -p {port}");

        choice_type.getItems().addAll(choiceTypes.keySet());

        choice_type.setOnAction(actionEvent -> {
            String key = choice_type.getSelectionModel().getSelectedItem();
            String value = choiceTypes.get(key);
            String listener_value = value.replace("{port}", getIP());
            System.out.println(listener_value);
            genListener.setText(listener_value);
        });
    }


}
