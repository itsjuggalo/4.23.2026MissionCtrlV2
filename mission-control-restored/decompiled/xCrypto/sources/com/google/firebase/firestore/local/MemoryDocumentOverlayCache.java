package com.google.firebase.firestore.local;

import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.model.mutation.Mutation;
import com.google.firebase.firestore.model.mutation.Overlay;
import com.google.firebase.firestore.util.Preconditions;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
public class MemoryDocumentOverlayCache implements DocumentOverlayCache {
    private final TreeMap<DocumentKey, Overlay> overlays = new TreeMap<>();
    private final Map<Integer, Set<DocumentKey>> overlayByBatchId = new HashMap();

    private void saveOverlay(int i4, Mutation mutation) {
        Overlay overlay = this.overlays.get(mutation.getKey());
        if (overlay != null) {
            this.overlayByBatchId.get(Integer.valueOf(overlay.getLargestBatchId())).remove(mutation.getKey());
        }
        this.overlays.put(mutation.getKey(), Overlay.create(i4, mutation));
        if (this.overlayByBatchId.get(Integer.valueOf(i4)) == null) {
            this.overlayByBatchId.put(Integer.valueOf(i4), new HashSet());
        }
        this.overlayByBatchId.get(Integer.valueOf(i4)).add(mutation.getKey());
    }

    @Override // com.google.firebase.firestore.local.DocumentOverlayCache
    public Overlay getOverlay(DocumentKey documentKey) {
        return this.overlays.get(documentKey);
    }

    @Override // com.google.firebase.firestore.local.DocumentOverlayCache
    public Map<DocumentKey, Overlay> getOverlays(SortedSet<DocumentKey> sortedSet) {
        HashMap map = new HashMap();
        for (DocumentKey documentKey : sortedSet) {
            Overlay overlay = this.overlays.get(documentKey);
            if (overlay != null) {
                map.put(documentKey, overlay);
            }
        }
        return map;
    }

    @Override // com.google.firebase.firestore.local.DocumentOverlayCache
    public void removeOverlaysForBatchId(int i4) {
        if (this.overlayByBatchId.containsKey(Integer.valueOf(i4))) {
            Set<DocumentKey> set = this.overlayByBatchId.get(Integer.valueOf(i4));
            this.overlayByBatchId.remove(Integer.valueOf(i4));
            Iterator<DocumentKey> it = set.iterator();
            while (it.hasNext()) {
                this.overlays.remove(it.next());
            }
        }
    }

    @Override // com.google.firebase.firestore.local.DocumentOverlayCache
    public void saveOverlays(int i4, Map<DocumentKey, Mutation> map) {
        for (Map.Entry<DocumentKey, Mutation> entry : map.entrySet()) {
            saveOverlay(i4, (Mutation) Preconditions.checkNotNull(entry.getValue(), "null value for key: %s", entry.getKey()));
        }
    }

    @Override // com.google.firebase.firestore.local.DocumentOverlayCache
    public Map<DocumentKey, Overlay> getOverlays(ResourcePath resourcePath, int i4) {
        HashMap map = new HashMap();
        int length = resourcePath.length() + 1;
        for (Overlay overlay : this.overlays.tailMap(DocumentKey.fromPath(resourcePath.append(""))).values()) {
            DocumentKey key = overlay.getKey();
            if (!resourcePath.isPrefixOf(key.getPath())) {
                break;
            }
            if (key.getPath().length() == length && overlay.getLargestBatchId() > i4) {
                map.put(overlay.getKey(), overlay);
            }
        }
        return map;
    }

    @Override // com.google.firebase.firestore.local.DocumentOverlayCache
    public Map<DocumentKey, Overlay> getOverlays(String str, int i4, int i5) {
        TreeMap treeMap = new TreeMap();
        for (Overlay overlay : this.overlays.values()) {
            if (overlay.getKey().getCollectionGroup().equals(str) && overlay.getLargestBatchId() > i4) {
                Map map = (Map) treeMap.get(Integer.valueOf(overlay.getLargestBatchId()));
                if (map == null) {
                    map = new HashMap();
                    treeMap.put(Integer.valueOf(overlay.getLargestBatchId()), map);
                }
                map.put(overlay.getKey(), overlay);
            }
        }
        HashMap map2 = new HashMap();
        Iterator it = treeMap.values().iterator();
        while (it.hasNext()) {
            map2.putAll((Map) it.next());
            if (map2.size() >= i5) {
                break;
            }
        }
        return map2;
    }
}
