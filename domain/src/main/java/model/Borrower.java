package model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table (name = "borrowers")
public class Borrower {
}
