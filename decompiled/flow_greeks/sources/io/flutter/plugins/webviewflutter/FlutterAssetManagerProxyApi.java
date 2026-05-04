package io.flutter.plugins.webviewflutter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class FlutterAssetManagerProxyApi extends PigeonApiFlutterAssetManager {
    public FlutterAssetManagerProxyApi(ProxyApiRegistrar proxyApiRegistrar) {
        super(proxyApiRegistrar);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiFlutterAssetManager
    public String getAssetFilePathByName(FlutterAssetManager flutterAssetManager, String str) {
        return flutterAssetManager.getAssetFilePathByName(str);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiFlutterAssetManager
    public FlutterAssetManager instance() {
        return getPigeonRegistrar().getFlutterAssetManager();
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiFlutterAssetManager
    public List<String> list(FlutterAssetManager flutterAssetManager, String str) {
        try {
            String[] list = flutterAssetManager.list(str);
            return list == null ? new ArrayList() : Arrays.asList(list);
        } catch (IOException e10) {
            throw new RuntimeException(e10.getMessage());
        }
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiFlutterAssetManager
    public ProxyApiRegistrar getPigeonRegistrar() {
        return (ProxyApiRegistrar) super.getPigeonRegistrar();
    }
}
