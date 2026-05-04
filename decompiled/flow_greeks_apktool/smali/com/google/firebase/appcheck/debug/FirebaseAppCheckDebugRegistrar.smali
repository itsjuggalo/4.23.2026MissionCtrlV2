.class public Lcom/google/firebase/appcheck/debug/FirebaseAppCheckDebugRegistrar;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Lcom/google/firebase/components/ComponentRegistrar;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    .line 3
    .line 4
    return-void
    .line 5
    .line 6
    .line 7
    .line 8
    .line 9
    .line 10
    .line 11
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
.end method

.method public static synthetic a(Lo7/e0;Lo7/e0;Lo7/e0;Lo7/d;)Lg7/e;
    .locals 6

    .line 1
    new-instance v0, Lg7/e;

    .line 2
    .line 3
    const-class v1, La7/g;

    .line 4
    .line 5
    invoke-interface {p3, v1}, Lo7/d;->get(Ljava/lang/Class;)Ljava/lang/Object;

    .line 6
    .line 7
    .line 8
    move-result-object v1

    .line 9
    check-cast v1, La7/g;

    .line 10
    .line 11
    const-class v2, Lf7/c;

    .line 12
    .line 13
    invoke-interface {p3, v2}, Lo7/d;->b(Ljava/lang/Class;)Lfa/b;

    .line 14
    .line 15
    .line 16
    move-result-object v2

    .line 17
    invoke-interface {p3, p0}, Lo7/d;->f(Lo7/e0;)Ljava/lang/Object;

    .line 18
    .line 19
    .line 20
    move-result-object p0

    .line 21
    move-object v3, p0

    .line 22
    check-cast v3, Ljava/util/concurrent/Executor;

    .line 23
    .line 24
    invoke-interface {p3, p1}, Lo7/d;->f(Lo7/e0;)Ljava/lang/Object;

    .line 25
    .line 26
    .line 27
    move-result-object p0

    .line 28
    move-object v4, p0

    .line 29
    check-cast v4, Ljava/util/concurrent/Executor;

    .line 30
    .line 31
    invoke-interface {p3, p2}, Lo7/d;->f(Lo7/e0;)Ljava/lang/Object;

    .line 32
    .line 33
    .line 34
    move-result-object p0

    .line 35
    move-object v5, p0

    .line 36
    check-cast v5, Ljava/util/concurrent/Executor;

    .line 37
    .line 38
    invoke-direct/range {v0 .. v5}, Lg7/e;-><init>(La7/g;Lfa/b;Ljava/util/concurrent/Executor;Ljava/util/concurrent/Executor;Ljava/util/concurrent/Executor;)V

    .line 39
    .line 40
    .line 41
    return-object v0
    .line 42
    .line 43
    .line 44
    .line 45
    .line 46
    .line 47
    .line 48
    .line 49
    .line 50
    .line 51
    .line 52
    .line 53
    .line 54
    .line 55
    .line 56
    .line 57
    .line 58
    .line 59
    .line 60
    .line 61
    .line 62
    .line 63
    .line 64
    .line 65
    .line 66
    .line 67
    .line 68
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
.end method


# virtual methods
.method public getComponents()Ljava/util/List;
    .locals 6

    .line 1
    const-class v0, Ld7/c;

    .line 2
    .line 3
    const-class v1, Ljava/util/concurrent/Executor;

    .line 4
    .line 5
    invoke-static {v0, v1}, Lo7/e0;->a(Ljava/lang/Class;Ljava/lang/Class;)Lo7/e0;

    .line 6
    .line 7
    .line 8
    move-result-object v0

    .line 9
    const-class v2, Ld7/a;

    .line 10
    .line 11
    invoke-static {v2, v1}, Lo7/e0;->a(Ljava/lang/Class;Ljava/lang/Class;)Lo7/e0;

    .line 12
    .line 13
    .line 14
    move-result-object v2

    .line 15
    const-class v3, Ld7/b;

    .line 16
    .line 17
    invoke-static {v3, v1}, Lo7/e0;->a(Ljava/lang/Class;Ljava/lang/Class;)Lo7/e0;

    .line 18
    .line 19
    .line 20
    move-result-object v1

    .line 21
    const-class v3, Lg7/e;

    .line 22
    .line 23
    invoke-static {v3}, Lo7/c;->c(Ljava/lang/Class;)Lo7/c$b;

    .line 24
    .line 25
    .line 26
    move-result-object v3

    .line 27
    const-string v4, "fire-app-check-debug"

    .line 28
    .line 29
    invoke-virtual {v3, v4}, Lo7/c$b;->h(Ljava/lang/String;)Lo7/c$b;

    .line 30
    .line 31
    .line 32
    move-result-object v3

    .line 33
    const-class v5, La7/g;

    .line 34
    .line 35
    invoke-static {v5}, Lo7/q;->k(Ljava/lang/Class;)Lo7/q;

    .line 36
    .line 37
    .line 38
    move-result-object v5

    .line 39
    invoke-virtual {v3, v5}, Lo7/c$b;->b(Lo7/q;)Lo7/c$b;

    .line 40
    .line 41
    .line 42
    move-result-object v3

    .line 43
    const-class v5, Lf7/c;

    .line 44
    .line 45
    invoke-static {v5}, Lo7/q;->i(Ljava/lang/Class;)Lo7/q;

    .line 46
    .line 47
    .line 48
    move-result-object v5

    .line 49
    invoke-virtual {v3, v5}, Lo7/c$b;->b(Lo7/q;)Lo7/c$b;

    .line 50
    .line 51
    .line 52
    move-result-object v3

    .line 53
    invoke-static {v0}, Lo7/q;->l(Lo7/e0;)Lo7/q;

    .line 54
    .line 55
    .line 56
    move-result-object v5

    .line 57
    invoke-virtual {v3, v5}, Lo7/c$b;->b(Lo7/q;)Lo7/c$b;

    .line 58
    .line 59
    .line 60
    move-result-object v3

    .line 61
    invoke-static {v2}, Lo7/q;->l(Lo7/e0;)Lo7/q;

    .line 62
    .line 63
    .line 64
    move-result-object v5

    .line 65
    invoke-virtual {v3, v5}, Lo7/c$b;->b(Lo7/q;)Lo7/c$b;

    .line 66
    .line 67
    .line 68
    move-result-object v3

    .line 69
    invoke-static {v1}, Lo7/q;->l(Lo7/e0;)Lo7/q;

    .line 70
    .line 71
    .line 72
    move-result-object v5

    .line 73
    invoke-virtual {v3, v5}, Lo7/c$b;->b(Lo7/q;)Lo7/c$b;

    .line 74
    .line 75
    .line 76
    move-result-object v3

    .line 77
    new-instance v5, Lf7/b;

    .line 78
    .line 79
    invoke-direct {v5, v0, v2, v1}, Lf7/b;-><init>(Lo7/e0;Lo7/e0;Lo7/e0;)V

    .line 80
    .line 81
    .line 82
    invoke-virtual {v3, v5}, Lo7/c$b;->f(Lo7/g;)Lo7/c$b;

    .line 83
    .line 84
    .line 85
    move-result-object v0

    .line 86
    invoke-virtual {v0}, Lo7/c$b;->d()Lo7/c;

    .line 87
    .line 88
    .line 89
    move-result-object v0

    .line 90
    const-string v1, "19.0.1"

    .line 91
    .line 92
    invoke-static {v4, v1}, Loa/h;->b(Ljava/lang/String;Ljava/lang/String;)Lo7/c;

    .line 93
    .line 94
    .line 95
    move-result-object v1

    .line 96
    filled-new-array {v0, v1}, [Lo7/c;

    .line 97
    .line 98
    .line 99
    move-result-object v0

    .line 100
    invoke-static {v0}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    .line 101
    .line 102
    .line 103
    move-result-object v0

    .line 104
    return-object v0
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
