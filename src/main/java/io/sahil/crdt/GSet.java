
package io.sahil.crdt;

import io.sahil.crdt.helpers.Operations;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class GSet<E> {

    private Set<E> set;

    public GSet() {
        set = new HashSet<>();
    }

    GSet(Set<E> set) {
        this.set = new HashSet<>(set);
    }

    public void add(final E elem) {
        set.add(elem);
    }

    public Set<E> lookup() {
        return Collections.unmodifiableSet(set);
    }

    public GSet<E> merge(GSet<E> anotherGSet) {
        final HashSet<E> newSet = new HashSet<>(set);
        newSet.addAll(anotherGSet.getSet());
        return new GSet<>(newSet);
    }

    public GSet<E> diff(GSet<E> anotherGSet) {
        return new GSet<>(Operations.diff(set, anotherGSet.lookup()));
    }

    // Visible for testing
    Set<E> getSet() {
        return set;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GSet<?> gSet = (GSet<?>) o;

        return set.equals(gSet.set);

    }

    @Override
    public int hashCode() {
        return set.hashCode();
    }
}
