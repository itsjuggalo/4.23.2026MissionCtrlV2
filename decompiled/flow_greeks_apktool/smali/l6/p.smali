.class public final Ll6/p;
.super Ll6/j;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# instance fields
.field public final synthetic b:Landroid/os/IBinder;

.field public final synthetic c:Ll6/r;


# direct methods
.method public constructor <init>(Ll6/r;Landroid/os/IBinder;)V
    .locals 0

    .line 1
    iput-object p2, p0, Ll6/p;->b:Landroid/os/IBinder;

    .line 2
    .line 3
    iput-object p1, p0, Ll6/p;->c:Ll6/r;

    .line 4
    .line 5
    invoke-direct {p0}, Ll6/j;-><init>()V

    .line 6
    .line 7
    .line 8
    return-void
    .line 9
    .line 10
    .line 11
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
    .line 17
    .line 18
    .line 19
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
    .line 27
    .line 28
    .line 29
    .line 30
    .line 31
    .line 32
    .line 33
    .line 34
    .line 35
    .line 36
    .line 37
    .line 38
    .line 39
.end method


# virtual methods
.method public final a()V
    .locals 2

    .line 1
    iget-object v0, p0, Ll6/p;->b:Landroid/os/IBinder;

    .line 2
    .line 3
    invoke-static {v0}, Ll6/e;->I(Landroid/os/IBinder;)Ll6/f;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    iget-object v1, p0, Ll6/p;->c:Ll6/r;

    .line 8
    .line 9
    iget-object v1, v1, Ll6/r;->a:Ll6/t;

    .line 10
    .line 11
    invoke-static {v1, v0}, Ll6/t;->m(Ll6/t;Landroid/os/IInterface;)V

    .line 12
    .line 13
    .line 14
    iget-object v0, p0, Ll6/p;->c:Ll6/r;

    .line 15
    .line 16
    iget-object v0, v0, Ll6/r;->a:Ll6/t;

    .line 17
    .line 18
    invoke-static {v0}, Ll6/t;->q(Ll6/t;)V

    .line 19
    .line 20
    .line 21
    iget-object v0, p0, Ll6/p;->c:Ll6/r;

    .line 22
    .line 23
    iget-object v0, v0, Ll6/r;->a:Ll6/t;

    .line 24
    .line 25
    const/4 v1, 0x0

    .line 26
    invoke-static {v0, v1}, Ll6/t;->l(Ll6/t;Z)V

    .line 27
    .line 28
    .line 29
    iget-object v0, p0, Ll6/p;->c:Ll6/r;

    .line 30
    .line 31
    iget-object v0, v0, Ll6/r;->a:Ll6/t;

    .line 32
    .line 33
    invoke-static {v0}, Ll6/t;->h(Ll6/t;)Ljava/util/List;

    .line 34
    .line 35
    .line 36
    move-result-object v0

    .line 37
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    .line 38
    .line 39
    .line 40
    move-result-object v0

    .line 41
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    .line 42
    .line 43
    .line 44
    move-result v1

    .line 45
    if-eqz v1, :cond_0

    .line 46
    .line 47
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 48
    .line 49
    .line 50
    move-result-object v1

    .line 51
    check-cast v1, Ljava/lang/Runnable;

    .line 52
    .line 53
    invoke-interface {v1}, Ljava/lang/Runnable;->run()V

    .line 54
    .line 55
    .line 56
    goto :goto_0

    .line 57
    :cond_0
    iget-object v0, p0, Ll6/p;->c:Ll6/r;

    .line 58
    .line 59
    iget-object v0, v0, Ll6/r;->a:Ll6/t;

    .line 60
    .line 61
    invoke-static {v0}, Ll6/t;->h(Ll6/t;)Ljava/util/List;

    .line 62
    .line 63
    .line 64
    move-result-object v0

    .line 65
    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 66
    .line 67
    .line 68
    return-void
    .line 69
    .line 70
    .line 71
    .line 72
    .line 73
    .line 74
    .line 75
    .line 76
    .line 77
    .line 78
    .line 79
    .line 80
    .line 81
    .line 82
    .line 83
    .line 84
    .line 85
    .line 86
    .line 87
    .line 88
    .line 89
    .line 90
    .line 91
    .line 92
    .line 93
    .line 94
    .line 95
    .line 96
    .line 97
    .line 98
    .line 99
    .line 100
    .line 101
    .line 102
    .line 103
    .line 104
    .line 105
    .line 106
    .line 107
    .line 108
    .line 109
    .line 110
    .line 111
    .line 112
    .line 113
    .line 114
    .line 115
    .line 116
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
