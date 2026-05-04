.class public final Lcom/google/android/gms/internal/auth_blockstore/zzab;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# static fields
.field public static final zza:Lm5/d;

.field public static final zzb:Lm5/d;

.field public static final zzc:Lm5/d;

.field public static final zzd:Lm5/d;

.field public static final zze:Lm5/d;

.field public static final zzf:Lm5/d;

.field public static final zzg:Lm5/d;

.field public static final zzh:Lm5/d;

.field public static final zzi:Lm5/d;

.field public static final zzj:Lm5/d;

.field public static final zzk:Lm5/d;

.field public static final zzl:[Lm5/d;


# direct methods
.method static constructor <clinit>()V
    .locals 14

    .line 1
    new-instance v0, Lm5/d;

    .line 2
    .line 3
    const-string v1, "auth_blockstore"

    .line 4
    .line 5
    const-wide/16 v2, 0x3

    .line 6
    .line 7
    invoke-direct {v0, v1, v2, v3}, Lm5/d;-><init>(Ljava/lang/String;J)V

    .line 8
    .line 9
    .line 10
    sput-object v0, Lcom/google/android/gms/internal/auth_blockstore/zzab;->zza:Lm5/d;

    .line 11
    .line 12
    new-instance v1, Lm5/d;

    .line 13
    .line 14
    const-string v4, "blockstore_data_transfer"

    .line 15
    .line 16
    const-wide/16 v5, 0x1

    .line 17
    .line 18
    invoke-direct {v1, v4, v5, v6}, Lm5/d;-><init>(Ljava/lang/String;J)V

    .line 19
    .line 20
    .line 21
    sput-object v1, Lcom/google/android/gms/internal/auth_blockstore/zzab;->zzb:Lm5/d;

    .line 22
    .line 23
    move-wide v3, v2

    .line 24
    new-instance v2, Lm5/d;

    .line 25
    .line 26
    const-string v7, "blockstore_notify_app_restore"

    .line 27
    .line 28
    invoke-direct {v2, v7, v5, v6}, Lm5/d;-><init>(Ljava/lang/String;J)V

    .line 29
    .line 30
    .line 31
    sput-object v2, Lcom/google/android/gms/internal/auth_blockstore/zzab;->zzc:Lm5/d;

    .line 32
    .line 33
    move-wide v7, v3

    .line 34
    new-instance v3, Lm5/d;

    .line 35
    .line 36
    const-string v4, "blockstore_store_bytes_with_options"

    .line 37
    .line 38
    const-wide/16 v9, 0x2

    .line 39
    .line 40
    invoke-direct {v3, v4, v9, v10}, Lm5/d;-><init>(Ljava/lang/String;J)V

    .line 41
    .line 42
    .line 43
    sput-object v3, Lcom/google/android/gms/internal/auth_blockstore/zzab;->zzd:Lm5/d;

    .line 44
    .line 45
    new-instance v4, Lm5/d;

    .line 46
    .line 47
    const-string v11, "blockstore_is_end_to_end_encryption_available"

    .line 48
    .line 49
    invoke-direct {v4, v11, v5, v6}, Lm5/d;-><init>(Ljava/lang/String;J)V

    .line 50
    .line 51
    .line 52
    sput-object v4, Lcom/google/android/gms/internal/auth_blockstore/zzab;->zze:Lm5/d;

    .line 53
    .line 54
    move-wide v11, v5

    .line 55
    new-instance v5, Lm5/d;

    .line 56
    .line 57
    const-string v6, "blockstore_enable_cloud_backup"

    .line 58
    .line 59
    invoke-direct {v5, v6, v11, v12}, Lm5/d;-><init>(Ljava/lang/String;J)V

    .line 60
    .line 61
    .line 62
    sput-object v5, Lcom/google/android/gms/internal/auth_blockstore/zzab;->zzf:Lm5/d;

    .line 63
    .line 64
    new-instance v6, Lm5/d;

    .line 65
    .line 66
    const-string v13, "blockstore_delete_bytes"

    .line 67
    .line 68
    invoke-direct {v6, v13, v9, v10}, Lm5/d;-><init>(Ljava/lang/String;J)V

    .line 69
    .line 70
    .line 71
    sput-object v6, Lcom/google/android/gms/internal/auth_blockstore/zzab;->zzg:Lm5/d;

    .line 72
    .line 73
    move-wide v8, v7

    .line 74
    new-instance v7, Lm5/d;

    .line 75
    .line 76
    const-string v10, "blockstore_retrieve_bytes_with_options"

    .line 77
    .line 78
    invoke-direct {v7, v10, v8, v9}, Lm5/d;-><init>(Ljava/lang/String;J)V

    .line 79
    .line 80
    .line 81
    sput-object v7, Lcom/google/android/gms/internal/auth_blockstore/zzab;->zzh:Lm5/d;

    .line 82
    .line 83
    new-instance v8, Lm5/d;

    .line 84
    .line 85
    const-string v9, "auth_clear_restore_credential"

    .line 86
    .line 87
    invoke-direct {v8, v9, v11, v12}, Lm5/d;-><init>(Ljava/lang/String;J)V

    .line 88
    .line 89
    .line 90
    sput-object v8, Lcom/google/android/gms/internal/auth_blockstore/zzab;->zzi:Lm5/d;

    .line 91
    .line 92
    new-instance v9, Lm5/d;

    .line 93
    .line 94
    const-string v10, "auth_create_restore_credential"

    .line 95
    .line 96
    invoke-direct {v9, v10, v11, v12}, Lm5/d;-><init>(Ljava/lang/String;J)V

    .line 97
    .line 98
    .line 99
    sput-object v9, Lcom/google/android/gms/internal/auth_blockstore/zzab;->zzj:Lm5/d;

    .line 100
    .line 101
    new-instance v10, Lm5/d;

    .line 102
    .line 103
    const-string v13, "auth_get_restore_credential"

    .line 104
    .line 105
    invoke-direct {v10, v13, v11, v12}, Lm5/d;-><init>(Ljava/lang/String;J)V

    .line 106
    .line 107
    .line 108
    sput-object v10, Lcom/google/android/gms/internal/auth_blockstore/zzab;->zzk:Lm5/d;

    .line 109
    .line 110
    filled-new-array/range {v0 .. v10}, [Lm5/d;

    .line 111
    .line 112
    .line 113
    move-result-object v0

    .line 114
    sput-object v0, Lcom/google/android/gms/internal/auth_blockstore/zzab;->zzl:[Lm5/d;

    .line 115
    .line 116
    return-void
    .line 117
    .line 118
    .line 119
    .line 120
    .line 121
    .line 122
    .line 123
    .line 124
    .line 125
    .line 126
    .line 127
    .line 128
    .line 129
    .line 130
    .line 131
    .line 132
    .line 133
    .line 134
    .line 135
    .line 136
    .line 137
    .line 138
    .line 139
    .line 140
    .line 141
    .line 142
    .line 143
    .line 144
    .line 145
    .line 146
    .line 147
    .line 148
    .line 149
    .line 150
    .line 151
    .line 152
    .line 153
    .line 154
    .line 155
    .line 156
    .line 157
    .line 158
    .line 159
    .line 160
    .line 161
    .line 162
    .line 163
    .line 164
    .line 165
    .line 166
    .line 167
    .line 168
    .line 169
    .line 170
    .line 171
    .line 172
    .line 173
    .line 174
    .line 175
    .line 176
    .line 177
    .line 178
    .line 179
    .line 180
    .line 181
    .line 182
    .line 183
    .line 184
    .line 185
    .line 186
    .line 187
    .line 188
    .line 189
    .line 190
    .line 191
    .line 192
    .line 193
    .line 194
    .line 195
    .line 196
.end method
