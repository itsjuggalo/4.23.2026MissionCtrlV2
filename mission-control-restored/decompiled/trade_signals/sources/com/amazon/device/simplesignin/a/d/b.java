package com.amazon.device.simplesignin.a.d;

import com.amazon.device.simplesignin.model.Link;
import com.amazon.device.simplesignin.model.Token;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f14653a = "b";

    private b() {
    }

    public static String a(String str) {
        try {
            return new JSONObject(str).getString(com.amazon.device.simplesignin.a.a.a.f14588y);
        } catch (JSONException e8) {
            a.b(f14653a, "Failure extracting Link ID object from response." + e8);
            return null;
        }
    }

    public static List<Link> a(String str, String str2) {
        String str3;
        StringBuilder sb;
        String str4;
        try {
            JSONArray jSONArray = new JSONArray(str2);
            if (jSONArray.length() == 0) {
                a.a(f14653a, "No links available, links object received is empty.");
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList(jSONArray.length());
            for (int i8 = 0; i8 < jSONArray.length(); i8++) {
                try {
                    JSONObject jSONObject = (JSONObject) jSONArray.get(i8);
                    Link link = new Link();
                    link.setAmazonUserId(str);
                    link.setIdentityProviderName(jSONObject.getString(com.amazon.device.simplesignin.a.a.a.f14589z));
                    link.setLinkId(jSONObject.getString(com.amazon.device.simplesignin.a.a.a.f14588y));
                    link.setPartnerUserId(jSONObject.getString(com.amazon.device.simplesignin.a.a.a.f14552A));
                    link.setLinkedTimestamp(jSONObject.getLong(com.amazon.device.simplesignin.a.a.a.f14553B));
                    Token token = new Token();
                    JSONObject jSONObject2 = new JSONObject(jSONObject.getString(com.amazon.device.simplesignin.a.a.a.f14554C));
                    token.setToken(jSONObject2.getString("token"));
                    token.setSchema(jSONObject2.getString(com.amazon.device.simplesignin.a.a.a.f14556E));
                    link.setSsiToken(token);
                    arrayList.add(link);
                } catch (JSONException e8) {
                    e = e8;
                    str3 = f14653a;
                    sb = new StringBuilder();
                    str4 = "Failure generating Link object from response.";
                }
            }
            return arrayList;
        } catch (JSONException e9) {
            e = e9;
            str3 = f14653a;
            sb = new StringBuilder();
            str4 = "Failure generating Link object from Kiwi response.";
        }
        sb.append(str4);
        sb.append(e);
        a.b(str3, sb.toString());
        return null;
    }
}
