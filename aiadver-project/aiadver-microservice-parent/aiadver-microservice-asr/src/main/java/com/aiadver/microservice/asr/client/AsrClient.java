package com.aiadver.microservice.asr.client;

import com.aiadver.api.asr.thrift.ASRServ;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

/**
 * ASR 客户端
 *
 * @author george
 */
@NoArgsConstructor
@RequiredArgsConstructor
public class AsrClient {

    @NonNull
    private String host;

    @NonNull
    private Integer port;

    private TTransport tTransport;

    private TProtocol tProtocol;

    @Getter
    private ASRServ.Client asrService;

    public void init() {
        tTransport = new TFramedTransport(new TSocket(host, port), 600);
        //协议对象 这里使用协议对象需要和服务器的一致
        tProtocol = new TCompactProtocol(tTransport);
        asrService = new ASRServ.Client(tProtocol);
    }

    public void open() throws TTransportException {
        if (null != tTransport && !tTransport.isOpen()) {
            tTransport.open();
        }
    }

    public void close() {
        if (null != tTransport && tTransport.isOpen()) {
            tTransport.close();
        }
    }
}
