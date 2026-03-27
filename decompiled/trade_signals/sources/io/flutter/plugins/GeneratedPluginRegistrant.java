package io.flutter.plugins;

import A4.f;
import B4.e;
import androidx.annotation.Keep;
import com.dexterous.flutterlocalnotifications.FlutterLocalNotificationsPlugin;
import com.revenuecat.purchases_flutter.PurchasesFlutterPlugin;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugins.firebase.analytics.FlutterFirebaseAnalyticsPlugin;
import io.flutter.plugins.firebase.core.FlutterFirebaseCorePlugin;
import io.flutter.plugins.firebase.database.FirebaseDatabasePlugin;
import io.flutter.plugins.firebase.firebaseremoteconfig.FirebaseRemoteConfigPlugin;
import io.flutter.plugins.firebase.messaging.FlutterFirebaseMessagingPlugin;
import io.flutter.plugins.pathprovider.PathProviderPlugin;
import io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin;
import io.flutter.plugins.urllauncher.UrlLauncherPlugin;
import io.flutter.plugins.webviewflutter.WebViewFlutterPlugin;
import s7.a;
import t4.C2748a;
import u4.C2773a;
import v4.C2864D;
import y4.l;
import z4.C3009b;

/* JADX INFO: loaded from: classes.dex */
@Keep
public final class GeneratedPluginRegistrant {
    private static final String TAG = "GeneratedPluginRegistrant";

    public static void registerWith(FlutterEngine flutterEngine) {
        try {
            flutterEngine.getPlugins().add(new C2773a());
        } catch (Exception e8) {
            Log.e(TAG, "Error registering plugin app_settings, com.spencerccf.app_settings.AppSettingsPlugin", e8);
        }
        try {
            flutterEngine.getPlugins().add(new FlutterFirebaseAnalyticsPlugin());
        } catch (Exception e9) {
            Log.e(TAG, "Error registering plugin firebase_analytics, io.flutter.plugins.firebase.analytics.FlutterFirebaseAnalyticsPlugin", e9);
        }
        try {
            flutterEngine.getPlugins().add(new FlutterFirebaseCorePlugin());
        } catch (Exception e10) {
            Log.e(TAG, "Error registering plugin firebase_core, io.flutter.plugins.firebase.core.FlutterFirebaseCorePlugin", e10);
        }
        try {
            flutterEngine.getPlugins().add(new FirebaseDatabasePlugin());
        } catch (Exception e11) {
            Log.e(TAG, "Error registering plugin firebase_database, io.flutter.plugins.firebase.database.FirebaseDatabasePlugin", e11);
        }
        try {
            flutterEngine.getPlugins().add(new FlutterFirebaseMessagingPlugin());
        } catch (Exception e12) {
            Log.e(TAG, "Error registering plugin firebase_messaging, io.flutter.plugins.firebase.messaging.FlutterFirebaseMessagingPlugin", e12);
        }
        try {
            flutterEngine.getPlugins().add(new FirebaseRemoteConfigPlugin());
        } catch (Exception e13) {
            Log.e(TAG, "Error registering plugin firebase_remote_config, io.flutter.plugins.firebase.firebaseremoteconfig.FirebaseRemoteConfigPlugin", e13);
        }
        try {
            flutterEngine.getPlugins().add(new C3009b());
        } catch (Exception e14) {
            Log.e(TAG, "Error registering plugin flutter_background, de.julianassmann.flutter_background.FlutterBackgroundPlugin", e14);
        }
        try {
            flutterEngine.getPlugins().add(new C2748a());
        } catch (Exception e15) {
            Log.e(TAG, "Error registering plugin flutter_email_sender, com.sidlatau.flutteremailsender.FlutterEmailSenderPlugin", e15);
        }
        try {
            flutterEngine.getPlugins().add(new FlutterLocalNotificationsPlugin());
        } catch (Exception e16) {
            Log.e(TAG, "Error registering plugin flutter_local_notifications, com.dexterous.flutterlocalnotifications.FlutterLocalNotificationsPlugin", e16);
        }
        try {
            flutterEngine.getPlugins().add(new a());
        } catch (Exception e17) {
            Log.e(TAG, "Error registering plugin flutter_native_splash, net.jonhanson.flutter_native_splash.FlutterNativeSplashPlugin", e17);
        }
        try {
            flutterEngine.getPlugins().add(new t7.a());
        } catch (Exception e18) {
            Log.e(TAG, "Error registering plugin flutter_timezone, net.wolverinebeach.flutter_timezone.FlutterTimezonePlugin", e18);
        }
        try {
            flutterEngine.getPlugins().add(new f());
        } catch (Exception e19) {
            Log.e(TAG, "Error registering plugin in_app_review, dev.britannio.in_app_review.InAppReviewPlugin", e19);
        }
        try {
            flutterEngine.getPlugins().add(new l());
        } catch (Exception e20) {
            Log.e(TAG, "Error registering plugin in_app_update, de.ffuf.in_app_update.InAppUpdatePlugin", e20);
        }
        try {
            flutterEngine.getPlugins().add(new PathProviderPlugin());
        } catch (Exception e21) {
            Log.e(TAG, "Error registering plugin path_provider_android, io.flutter.plugins.pathprovider.PathProviderPlugin", e21);
        }
        try {
            flutterEngine.getPlugins().add(new PurchasesFlutterPlugin());
        } catch (Exception e22) {
            Log.e(TAG, "Error registering plugin purchases_flutter, com.revenuecat.purchases_flutter.PurchasesFlutterPlugin", e22);
        }
        try {
            flutterEngine.getPlugins().add(new e());
        } catch (Exception e23) {
            Log.e(TAG, "Error registering plugin share_plus, dev.fluttercommunity.plus.share.SharePlusPlugin", e23);
        }
        try {
            flutterEngine.getPlugins().add(new SharedPreferencesPlugin());
        } catch (Exception e24) {
            Log.e(TAG, "Error registering plugin shared_preferences_android, io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin", e24);
        }
        try {
            flutterEngine.getPlugins().add(new C2864D());
        } catch (Exception e25) {
            Log.e(TAG, "Error registering plugin sqflite_android, com.tekartik.sqflite.SqflitePlugin", e25);
        }
        try {
            flutterEngine.getPlugins().add(new UrlLauncherPlugin());
        } catch (Exception e26) {
            Log.e(TAG, "Error registering plugin url_launcher_android, io.flutter.plugins.urllauncher.UrlLauncherPlugin", e26);
        }
        try {
            flutterEngine.getPlugins().add(new WebViewFlutterPlugin());
        } catch (Exception e27) {
            Log.e(TAG, "Error registering plugin webview_flutter_android, io.flutter.plugins.webviewflutter.WebViewFlutterPlugin", e27);
        }
    }
}
