package d.f.j;

/* JADX INFO: loaded from: classes.dex */
public class d<F, S> {
    public final F a;
    public final S b;

    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return c.a(dVar.a, this.a) && c.a(dVar.b, this.b);
    }

    public int hashCode() {
        F f2 = this.a;
        int iHashCode = f2 == null ? 0 : f2.hashCode();
        S s = this.b;
        return iHashCode ^ (s != null ? s.hashCode() : 0);
    }

    public String toString() {
        return "Pair{" + String.valueOf(this.a) + " " + String.valueOf(this.b) + "}";
    }
}
