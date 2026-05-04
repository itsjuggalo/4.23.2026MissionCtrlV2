.class public abstract Ly4/h;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# static fields
.field public static final a:Lm5/d;

.field public static final b:Lm5/d;

.field public static final c:Lm5/d;

.field public static final d:Lm5/d;

.field public static final e:Lm5/d;

.field public static final f:Lm5/d;

.field public static final g:Lm5/d;

.field public static final h:Lm5/d;

.field public static final i:Lm5/d;

.field public static final j:Lm5/d;

.field public static final k:Lm5/d;

.field public static final l:Lm5/d;

.field public static final m:Lm5/d;

.field public static final n:Lm5/d;

.field public static final o:Lm5/d;

.field public static final p:Lm5/d;

.field public static final q:[Lm5/d;


# direct methods
.method static constructor <clinit>()V
    .locals 19

    .line 1
    new-instance v1, Lm5/d;

    .line 2
    .line 3
    const-string v0, "account_capability_api"

    .line 4
    .line 5
    const-wide/16 v2, 0x1

    .line 6
    .line 7
    invoke-direct {v1, v0, v2, v3}, Lm5/d;-><init>(Ljava/lang/String;J)V

    .line 8
    .line 9
    .line 10
    sput-object v1, Ly4/h;->a:Lm5/d;

    .line 11
    .line 12
    new-instance v0, Lm5/d;

    .line 13
    .line 14
    const-string v4, "account_data_service"

    .line 15
    .line 16
    const-wide/16 v5, 0x6

    .line 17
    .line 18
    invoke-direct {v0, v4, v5, v6}, Lm5/d;-><init>(Ljava/lang/String;J)V

    .line 19
    .line 20
    .line 21
    sput-object v0, Ly4/h;->b:Lm5/d;

    .line 22
    .line 23
    new-instance v4, Lm5/d;

    .line 24
    .line 25
    const-string v5, "account_data_service_legacy"

    .line 26
    .line 27
    invoke-direct {v4, v5, v2, v3}, Lm5/d;-><init>(Ljava/lang/String;J)V

    .line 28
    .line 29
    .line 30
    sput-object v4, Ly4/h;->c:Lm5/d;

    .line 31
    .line 32
    move-object v5, v4

    .line 33
    new-instance v4, Lm5/d;

    .line 34
    .line 35
    const-string v6, "account_data_service_token"

    .line 36
    .line 37
    const-wide/16 v7, 0x8

    .line 38
    .line 39
    invoke-direct {v4, v6, v7, v8}, Lm5/d;-><init>(Ljava/lang/String;J)V

    .line 40
    .line 41
    .line 42
    sput-object v4, Ly4/h;->d:Lm5/d;

    .line 43
    .line 44
    move-object v6, v5

    .line 45
    new-instance v5, Lm5/d;

    .line 46
    .line 47
    const-string v7, "account_data_service_visibility"

    .line 48
    .line 49
    invoke-direct {v5, v7, v2, v3}, Lm5/d;-><init>(Ljava/lang/String;J)V

    .line 50
    .line 51
    .line 52
    sput-object v5, Ly4/h;->e:Lm5/d;

    .line 53
    .line 54
    move-object v7, v6

    .line 55
    new-instance v6, Lm5/d;

    .line 56
    .line 57
    const-string v8, "config_sync"

    .line 58
    .line 59
    invoke-direct {v6, v8, v2, v3}, Lm5/d;-><init>(Ljava/lang/String;J)V

    .line 60
    .line 61
    .line 62
    sput-object v6, Ly4/h;->f:Lm5/d;

    .line 63
    .line 64
    move-object v8, v7

    .line 65
    new-instance v7, Lm5/d;

    .line 66
    .line 67
    const-string v9, "device_account_api"

    .line 68
    .line 69
    invoke-direct {v7, v9, v2, v3}, Lm5/d;-><init>(Ljava/lang/String;J)V

    .line 70
    .line 71
    .line 72
    sput-object v7, Ly4/h;->g:Lm5/d;

    .line 73
    .line 74
    move-object v9, v8

    .line 75
    new-instance v8, Lm5/d;

    .line 76
    .line 77
    const-string v10, "device_account_jwt_creation"

    .line 78
    .line 79
    invoke-direct {v8, v10, v2, v3}, Lm5/d;-><init>(Ljava/lang/String;J)V

    .line 80
    .line 81
    .line 82
    sput-object v8, Ly4/h;->h:Lm5/d;

    .line 83
    .line 84
    move-object v10, v9

    .line 85
    new-instance v9, Lm5/d;

    .line 86
    .line 87
    const-string v11, "gaiaid_primary_email_api"

    .line 88
    .line 89
    invoke-direct {v9, v11, v2, v3}, Lm5/d;-><init>(Ljava/lang/String;J)V

    .line 90
    .line 91
    .line 92
    sput-object v9, Ly4/h;->i:Lm5/d;

    .line 93
    .line 94
    move-object v11, v10

    .line 95
    new-instance v10, Lm5/d;

    .line 96
    .line 97
    const-string v12, "get_restricted_accounts_api"

    .line 98
    .line 99
    invoke-direct {v10, v12, v2, v3}, Lm5/d;-><init>(Ljava/lang/String;J)V

    .line 100
    .line 101
    .line 102
    sput-object v10, Ly4/h;->j:Lm5/d;

    .line 103
    .line 104
    move-object v12, v11

    .line 105
    new-instance v11, Lm5/d;

    .line 106
    .line 107
    const-string v13, "google_auth_service_accounts"

    .line 108
    .line 109
    const-wide/16 v14, 0x2

    .line 110
    .line 111
    invoke-direct {v11, v13, v14, v15}, Lm5/d;-><init>(Ljava/lang/String;J)V

    .line 112
    .line 113
    .line 114
    sput-object v11, Ly4/h;->k:Lm5/d;

    .line 115
    .line 116
    move-object v13, v12

    .line 117
    new-instance v12, Lm5/d;

    .line 118
    .line 119
    const-string v14, "google_auth_service_token"

    .line 120
    .line 121
    const-wide/16 v2, 0x3

    .line 122
    .line 123
    invoke-direct {v12, v14, v2, v3}, Lm5/d;-><init>(Ljava/lang/String;J)V

    .line 124
    .line 125
    .line 126
    sput-object v12, Ly4/h;->l:Lm5/d;

    .line 127
    .line 128
    move-object v3, v13

    .line 129
    new-instance v13, Lm5/d;

    .line 130
    .line 131
    const-string v2, "hub_mode_api"

    .line 132
    .line 133
    const-wide/16 v14, 0x1

    .line 134
    .line 135
    invoke-direct {v13, v2, v14, v15}, Lm5/d;-><init>(Ljava/lang/String;J)V

    .line 136
    .line 137
    .line 138
    sput-object v13, Ly4/h;->m:Lm5/d;

    .line 139
    .line 140
    new-instance v2, Lm5/d;

    .line 141
    .line 142
    move-object/from16 v16, v0

    .line 143
    .line 144
    const-string v0, "work_account_client_is_whitelisted"

    .line 145
    .line 146
    invoke-direct {v2, v0, v14, v15}, Lm5/d;-><init>(Ljava/lang/String;J)V

    .line 147
    .line 148
    .line 149
    sput-object v2, Ly4/h;->n:Lm5/d;

    .line 150
    .line 151
    new-instance v0, Lm5/d;

    .line 152
    .line 153
    move-object/from16 v17, v1

    .line 154
    .line 155
    const-string v1, "factory_reset_protection_api"

    .line 156
    .line 157
    invoke-direct {v0, v1, v14, v15}, Lm5/d;-><init>(Ljava/lang/String;J)V

    .line 158
    .line 159
    .line 160
    sput-object v0, Ly4/h;->o:Lm5/d;

    .line 161
    .line 162
    new-instance v1, Lm5/d;

    .line 163
    .line 164
    move-object/from16 v18, v0

    .line 165
    .line 166
    const-string v0, "google_auth_api"

    .line 167
    .line 168
    invoke-direct {v1, v0, v14, v15}, Lm5/d;-><init>(Ljava/lang/String;J)V

    .line 169
    .line 170
    .line 171
    sput-object v1, Ly4/h;->p:Lm5/d;

    .line 172
    .line 173
    move-object v14, v2

    .line 174
    move-object/from16 v2, v16

    .line 175
    .line 176
    move-object/from16 v15, v18

    .line 177
    .line 178
    move-object/from16 v16, v1

    .line 179
    .line 180
    move-object/from16 v1, v17

    .line 181
    .line 182
    filled-new-array/range {v1 .. v16}, [Lm5/d;

    .line 183
    .line 184
    .line 185
    move-result-object v0

    .line 186
    sput-object v0, Ly4/h;->q:[Lm5/d;

    .line 187
    .line 188
    return-void
    .line 189
    .line 190
    .line 191
    .line 192
    .line 193
    .line 194
    .line 195
    .line 196
.end method
