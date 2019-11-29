package com.springboot.demo.socketio.service.impl;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.springboot.demo.socketio.domain.PushMessage;
import com.springboot.demo.socketio.service.SocketIOService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Jim
 */
@Slf4j
@Service(value = "socketIOService")
public class SocketIOServiceImpl implements SocketIOService {

    /**
     * 用来存已连接的客户端
     */
    private static Map<String, SocketIOClient> clientMap = new ConcurrentHashMap<>();

    @Autowired
    private SocketIOServer socketIOServer;

    /**
     * Spring IoC容器创建之后，在加载SocketIOServiceImpl Bean之后启动
     *
     * @throws Exception e
     */
    @PostConstruct
    private void autoStartup() throws Exception {
        start();
    }

    /**
     * Spring IoC容器在销毁SocketIOServiceImpl Bean之前关闭,避免重启项目服务端口占用问题
     *
     * @throws Exception e
     */
    @PreDestroy
    private void autoStop() throws Exception {
        stop();
    }

    @Override
    public void start() {
        // 监听客户端连接
        socketIOServer.addConnectListener(client -> {
            String loginUserNum = getParamsByClient(client);
            if (loginUserNum != null) {
                log.info("user {} connect!", loginUserNum);
                clientMap.put(loginUserNum, client);
            }
        });

        // 监听客户端断开连接
        socketIOServer.addDisconnectListener(client -> {
            String loginUserNum = getParamsByClient(client);
            if (loginUserNum != null) {
                log.info("user {} disconnect!", loginUserNum);
                clientMap.remove(loginUserNum);
                client.disconnect();
            }
        });

        // 处理自定义的事件，与连接监听类似
        socketIOServer.addEventListener(PUSH_EVENT, PushMessage.class, (client, data, ackSender) -> {
            // TODO do something
            System.out.println(data);
        });
        socketIOServer.start();
    }

    @Override
    public void stop() {
        if (socketIOServer != null) {
            socketIOServer.stop();
            socketIOServer = null;
        }
    }

    @Override
    public void pushMessageToUser(PushMessage pushMessage) {
        String loginUserNum = pushMessage.getLoginUserNum();
        if (!StringUtils.isEmpty(loginUserNum)) {
            SocketIOClient client = clientMap.get(loginUserNum);
            if (client != null) {
                client.sendEvent(PUSH_EVENT, pushMessage);
            }
        }
    }

    /**
     * 此方法为获取client连接中的参数，可根据需求更改
     *
     * @param client client
     * @return String
     */
    private String getParamsByClient(SocketIOClient client) {
        // 从请求的连接中拿出参数（这里的loginUserNum必须是唯一标识）
        Map<String, List<String>> params = client.getHandshakeData().getUrlParams();
        List<String> list = params.get("loginUserNum");
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }
}
