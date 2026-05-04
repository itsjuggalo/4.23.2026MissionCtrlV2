.class public final Ln6/b;
.super Ln6/w0;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# instance fields
.field public final synthetic g:Landroid/os/IBinder;

.field public final synthetic h:Ln6/e;


# direct methods
.method public constructor <init>(Ln6/e;Landroid/os/IBinder;)V
    .locals 0

    .line 1
    iput-object p2, p0, Ln6/b;->g:Landroid/os/IBinder;

    .line 2
    .line 3
    iput-object p1, p0, Ln6/b;->h:Ln6/e;

    .line 4
    .line 5
    invoke-direct {p0}, Ln6/w0;-><init>()V

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
.method public final b()V
    .locals 2

    .line 1
    iget-object v0, p0, Ln6/b;->h:Ln6/e;

    .line 2
    .line 3
    iget-object v0, v0, Ln6/e;->a:Ln6/f;

    .line 4
    .line 5
    invoke-static {v0}, Ln6/f;->g(Ln6/f;)Ln6/c1;

    .line 6
    .line 7
    .line 8
    move-result-object v0

    .line 9
    iget-object v1, p0, Ln6/b;->g:Landroid/os/IBinder;

    .line 10
    .line 11
    invoke-interface {v0, v1}, Ln6/c1;->a(Landroid/os/IBinder;)Ljava/lang/Object;

    .line 12
    .line 13
    .line 14
    move-result-object v0

    .line 15
    check-cast v0, Landroid/os/IInterface;

    .line 16
    .line 17
    iget-object v1, p0, Ln6/b;->h:Ln6/e;

    .line 18
    .line 19
    iget-object v1, v1, Ln6/e;->a:Ln6/f;

    .line 20
    .line 21
    invoke-static {v1, v0}, Ln6/f;->n(Ln6/f;Landroid/os/IInterface;)V

    .line 22
    .line 23
    .line 24
    iget-object v0, p0, Ln6/b;->h:Ln6/e;

    .line 25
    .line 26
    iget-object v0, v0, Ln6/e;->a:Ln6/f;

    .line 27
    .line 28
    invoke-static {v0}, Ln6/f;->r(Ln6/f;)V

    .line 29
    .line 30
    .line 31
    iget-object v0, p0, Ln6/b;->h:Ln6/e;

    .line 32
    .line 33
    iget-object v0, v0, Ln6/e;->a:Ln6/f;

    .line 34
    .line 35
    const/4 v1, 0x0

    .line 36
    invoke-static {v0, v1}, Ln6/f;->m(Ln6/f;Z)V

    .line 37
    .line 38
    .line 39
    iget-object v0, p0, Ln6/b;->h:Ln6/e;

    .line 40
    .line 41
    iget-object v0, v0, Ln6/e;->a:Ln6/f;

    .line 42
    .line 43
    invoke-static {v0}, Ln6/f;->i(Ln6/f;)Ljava/util/List;

    .line 44
    .line 45
    .line 46
    move-result-object v0

    .line 47
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    .line 48
    .line 49
    .line 50
    move-result-object v0

    .line 51
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    .line 52
    .line 53
    .line 54
    move-result v1

    .line 55
    if-eqz v1, :cond_0

    .line 56
    .line 57
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 58
    .line 59
    .line 60
    move-result-object v1

    .line 61
    check-cast v1, Ljava/lang/Runnable;

    .line 62
    .line 63
    invoke-interface {v1}, Ljava/lang/Runnable;->run()V

    .line 64
    .line 65
    .line 66
    goto :goto_0

    .line 67
    :cond_0
    iget-object v0, p0, Ln6/b;->h:Ln6/e;

    .line 68
    .line 69
    iget-object v0, v0, Ln6/e;->a:Ln6/f;

    .line 70
    .line 71
    invoke-static {v0}, Ln6/f;->i(Ln6/f;)Ljava/util/List;

    .line 72
    .line 73
    .line 74
    move-result-object v0

    .line 75
    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 76
    .line 77
    .line 78
    return-void
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
