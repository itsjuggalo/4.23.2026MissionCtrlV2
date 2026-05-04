.class public Lx6/a$b;
.super Lx6/a$a;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lx6/a;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "b"
.end annotation


# instance fields
.field public final d:[J


# direct methods
.method public constructor <init>()V
    .locals 4

    const/16 v0, 0xa

    .line 1
    new-array v1, v0, [J

    new-array v2, v0, [J

    new-array v3, v0, [J

    new-array v0, v0, [J

    invoke-direct {p0, v1, v2, v3, v0}, Lx6/a$b;-><init>([J[J[J[J)V

    return-void
.end method

.method public constructor <init>(Lx6/a$e;)V
    .locals 4

    .line 2
    invoke-direct {p0}, Lx6/a$b;-><init>()V

    .line 3
    iget-object v0, p0, Lx6/a$a;->a:[J

    iget-object v1, p1, Lx6/a$e;->a:Lx6/a$d;

    iget-object v2, v1, Lx6/a$d;->b:[J

    iget-object v1, v1, Lx6/a$d;->a:[J

    invoke-static {v0, v2, v1}, Lx6/f;->n([J[J[J)V

    .line 4
    iget-object v0, p0, Lx6/a$a;->b:[J

    iget-object v1, p1, Lx6/a$e;->a:Lx6/a$d;

    iget-object v2, v1, Lx6/a$d;->b:[J

    iget-object v1, v1, Lx6/a$d;->a:[J

    invoke-static {v0, v2, v1}, Lx6/f;->m([J[J[J)V

    .line 5
    iget-object v0, p1, Lx6/a$e;->a:Lx6/a$d;

    iget-object v0, v0, Lx6/a$d;->c:[J

    iget-object v1, p0, Lx6/a$b;->d:[J

    const/16 v2, 0xa

    const/4 v3, 0x0

    invoke-static {v0, v3, v1, v3, v2}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 6
    iget-object v0, p0, Lx6/a$a;->c:[J

    iget-object p1, p1, Lx6/a$e;->b:[J

    sget-object v1, Lx6/b;->b:[J

    invoke-static {v0, p1, v1}, Lx6/f;->f([J[J[J)V

    return-void
.end method

.method public constructor <init>([J[J[J[J)V
    .locals 0

    .line 7
    invoke-direct {p0, p1, p2, p4}, Lx6/a$a;-><init>([J[J[J)V

    .line 8
    iput-object p3, p0, Lx6/a$b;->d:[J

    return-void
.end method


# virtual methods
.method public a([J[J)V
    .locals 1

    .line 1
    iget-object v0, p0, Lx6/a$b;->d:[J

    .line 2
    .line 3
    invoke-static {p1, p2, v0}, Lx6/f;->f([J[J[J)V

    .line 4
    .line 5
    .line 6
    return-void
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
