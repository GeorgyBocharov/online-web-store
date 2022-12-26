package ru.sbt.store.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sbt.store.core.entities.Shipment;

@Repository
public interface ShipmentRepository extends JpaRepository<Shipment, Long> {
}
