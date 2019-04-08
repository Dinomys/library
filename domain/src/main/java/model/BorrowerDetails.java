package model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table (name = "borrowerDetails")
public class BorrowerDetails {
}
