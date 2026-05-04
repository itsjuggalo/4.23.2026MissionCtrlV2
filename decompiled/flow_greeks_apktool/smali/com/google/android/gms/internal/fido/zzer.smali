.class public final Lcom/google/android/gms/internal/fido/zzer;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Lcom/google/android/gms/internal/fido/zzek;


# instance fields
.field private final zza:Ljava/lang/String;

.field private final zzb:Lcom/google/android/gms/internal/fido/zzdn;

.field private final zzc:Ljava/util/logging/Level;

.field private final zzd:Ljava/util/Set;

.field private final zze:Lcom/google/android/gms/internal/fido/zzea;


# direct methods
.method private constructor <init>()V
    .locals 8

    .line 2
    sget-object v3, Lcom/google/android/gms/internal/fido/zzdo;->zzb:Lcom/google/android/gms/internal/fido/zzdo;

    sget-object v4, Ljava/util/logging/Level;->ALL:Ljava/util/logging/Level;

    invoke-static {}, Lcom/google/android/gms/internal/fido/zzeu;->zzd()Ljava/util/Set;

    move-result-object v6

    invoke-static {}, Lcom/google/android/gms/internal/fido/zzeu;->zzb()Lcom/google/android/gms/internal/fido/zzea;

    move-result-object v7

    const/4 v2, 0x1

    const/4 v5, 0x0

    const-string v1, ""

    move-object v0, p0

    invoke-direct/range {v0 .. v7}, Lcom/google/android/gms/internal/fido/zzer;-><init>(Ljava/lang/String;ZLcom/google/android/gms/internal/fido/zzdn;Ljava/util/logging/Level;ZLjava/util/Set;Lcom/google/android/gms/internal/fido/zzea;)V

    return-void
.end method

.method public synthetic constructor <init>(Lcom/google/android/gms/internal/fido/zzeq;)V
    .locals 8

    .line 3
    sget-object v3, Lcom/google/android/gms/internal/fido/zzdo;->zzb:Lcom/google/android/gms/internal/fido/zzdo;

    sget-object v4, Ljava/util/logging/Level;->ALL:Ljava/util/logging/Level;

    invoke-static {}, Lcom/google/android/gms/internal/fido/zzeu;->zzd()Ljava/util/Set;

    move-result-object v6

    invoke-static {}, Lcom/google/android/gms/internal/fido/zzeu;->zzb()Lcom/google/android/gms/internal/fido/zzea;

    move-result-object v7

    const/4 v2, 0x1

    const/4 v5, 0x0

    const-string v1, ""

    move-object v0, p0

    invoke-direct/range {v0 .. v7}, Lcom/google/android/gms/internal/fido/zzer;-><init>(Ljava/lang/String;ZLcom/google/android/gms/internal/fido/zzdn;Ljava/util/logging/Level;ZLjava/util/Set;Lcom/google/android/gms/internal/fido/zzea;)V

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ZLcom/google/android/gms/internal/fido/zzdn;Ljava/util/logging/Level;ZLjava/util/Set;Lcom/google/android/gms/internal/fido/zzea;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const-string p1, ""

    iput-object p1, p0, Lcom/google/android/gms/internal/fido/zzer;->zza:Ljava/lang/String;

    iput-object p3, p0, Lcom/google/android/gms/internal/fido/zzer;->zzb:Lcom/google/android/gms/internal/fido/zzdn;

    iput-object p4, p0, Lcom/google/android/gms/internal/fido/zzer;->zzc:Ljava/util/logging/Level;

    iput-object p6, p0, Lcom/google/android/gms/internal/fido/zzer;->zzd:Ljava/util/Set;

    iput-object p7, p0, Lcom/google/android/gms/internal/fido/zzer;->zze:Lcom/google/android/gms/internal/fido/zzea;

    return-void
.end method


# virtual methods
.method public final zza(Ljava/lang/String;)Lcom/google/android/gms/internal/fido/zzdp;
    .locals 9

    .line 1
    iget-object v4, p0, Lcom/google/android/gms/internal/fido/zzer;->zzb:Lcom/google/android/gms/internal/fido/zzdn;

    .line 2
    .line 3
    iget-object v5, p0, Lcom/google/android/gms/internal/fido/zzer;->zzc:Ljava/util/logging/Level;

    .line 4
    .line 5
    iget-object v6, p0, Lcom/google/android/gms/internal/fido/zzer;->zzd:Ljava/util/Set;

    .line 6
    .line 7
    iget-object v7, p0, Lcom/google/android/gms/internal/fido/zzer;->zze:Lcom/google/android/gms/internal/fido/zzea;

    .line 8
    .line 9
    new-instance v0, Lcom/google/android/gms/internal/fido/zzeu;

    .line 10
    .line 11
    iget-object v1, p0, Lcom/google/android/gms/internal/fido/zzer;->zza:Ljava/lang/String;

    .line 12
    .line 13
    const/4 v3, 0x1

    .line 14
    const/4 v8, 0x0

    .line 15
    move-object v2, p1

    .line 16
    invoke-direct/range {v0 .. v8}, Lcom/google/android/gms/internal/fido/zzeu;-><init>(Ljava/lang/String;Ljava/lang/String;ZLcom/google/android/gms/internal/fido/zzdn;Ljava/util/logging/Level;Ljava/util/Set;Lcom/google/android/gms/internal/fido/zzea;Lcom/google/android/gms/internal/fido/zzet;)V

    .line 17
    .line 18
    .line 19
    return-object v0
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
.end method

.method public final zzb(Z)Lcom/google/android/gms/internal/fido/zzer;
    .locals 8

    .line 1
    new-instance v0, Lcom/google/android/gms/internal/fido/zzer;

    .line 2
    .line 3
    iget-object v6, p0, Lcom/google/android/gms/internal/fido/zzer;->zzd:Ljava/util/Set;

    .line 4
    .line 5
    iget-object v7, p0, Lcom/google/android/gms/internal/fido/zzer;->zze:Lcom/google/android/gms/internal/fido/zzea;

    .line 6
    .line 7
    iget-object v3, p0, Lcom/google/android/gms/internal/fido/zzer;->zzb:Lcom/google/android/gms/internal/fido/zzdn;

    .line 8
    .line 9
    sget-object v4, Ljava/util/logging/Level;->OFF:Ljava/util/logging/Level;

    .line 10
    .line 11
    iget-object v1, p0, Lcom/google/android/gms/internal/fido/zzer;->zza:Ljava/lang/String;

    .line 12
    .line 13
    const/4 v2, 0x1

    .line 14
    const/4 v5, 0x0

    .line 15
    invoke-direct/range {v0 .. v7}, Lcom/google/android/gms/internal/fido/zzer;-><init>(Ljava/lang/String;ZLcom/google/android/gms/internal/fido/zzdn;Ljava/util/logging/Level;ZLjava/util/Set;Lcom/google/android/gms/internal/fido/zzea;)V

    .line 16
    .line 17
    .line 18
    return-object v0
    .line 19
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
.end method
