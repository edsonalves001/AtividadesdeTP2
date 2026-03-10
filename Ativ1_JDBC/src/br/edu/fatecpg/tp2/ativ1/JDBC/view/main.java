package br.edu.fatecpg.tp2.ativ1.JDBC.view;

import br.edu.fatecpg.tp2.ativ1.JDBC.db.DB;

import java.sql.ResultSet;
import java.util.Scanner;
import java.sql.PreparedStatement;
import java.sql.SQLDataException;
import java.sql.SQLException;

public class main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String opt = "";
        System.out.println("1-Adicionar Tarefa, " +
                "2-Editar Tarefa, 3-Excluir Tarefa, " +
                "4-Marcar todas como concluida, 5-Procurar por categoria ou status: ");
        String op = scan.nextLine();
        switch (op){
            case "1":
                System.out.println("Qual o nome da tarefa?? ");
                String nome = scan.nextLine().toLowerCase();
                System.out.println("Qual a categoria da tarefa?? ");
                String categoria = scan.nextLine().toLowerCase();
                System.out.println("A tarefa está em qual situação?? ");
                String status = scan.nextLine().toLowerCase();
                try(var conn = DB.connection()){
                    var query = "INSERT INTO tb_tarefas(nome,categoria,status) VALUES(?,?,?)";
                    PreparedStatement stmt = conn.prepareStatement(query);
                    stmt.setString(1,nome);
                    stmt.setString(2,categoria);
                    stmt.setString(3,status);
                    stmt.execute();
                    System.out.println("Tarefa Adicionada");
                } catch (SQLDataException e) {
                    throw new RuntimeException(e);
                } catch (SQLException e) {
                    System.err.println(e.getMessage());
                }
                break;
            case "2":
                System.out.println("Digite o nome da tarefa que queres editar: ");
                opt = scan.nextLine().toLowerCase();
                try(var conn = DB.connection()){
                    var query = "SELECT * FROM tb_tarefas WHERE nome = ?";
                    PreparedStatement stmt = conn.prepareStatement(query);
                    stmt.setString(1, opt);
                    ResultSet valores = stmt.executeQuery();
                    if(valores.next()){
                        String Novonome = "",Novacategoria = "",Novostatus ="";
                        System.out.println("Gostaria de alterar o nome  da tarefa " + valores.getString("nome") + " por: ");
                        Novonome = scan.nextLine().toLowerCase();
                        System.out.println("Qual a atual categoria da tarefa?");
                        Novacategoria = scan.nextLine().toLowerCase();
                        System.out.println("Qual a atual situação da tarefa?? ");
                        Novostatus = scan.nextLine().toLowerCase();
                        var novaQuery = "UPDATE tb_tarefas SET nome = ?, categoria =?,status =? WHERE nome = ?";
                        PreparedStatement stmt2 = conn.prepareStatement(novaQuery);
                        stmt2.setString(1,Novonome);
                        stmt2.setString(2,Novacategoria);
                        stmt2.setString(3,Novostatus);
                        stmt2.setString(4,valores.getString("nome"));
                        stmt2.executeUpdate();
                        System.out.println("Tarefa atualizada");
                    }else{
                        System.out.println("Tarefa não encontrada");
                    }

                } catch (SQLDataException e) {
                    throw new RuntimeException(e);
                } catch (SQLException e) {
                    System.err.println(e.getMessage());
                }
                break;
            case "3":
                System.out.println("Digite o nome da tarefa que queres excluir: ");
                opt = scan.nextLine().toLowerCase();
                try(var conn = DB.connection()){
                    var query = "SELECT * FROM tb_tarefas WHERE nome = ?";
                    PreparedStatement stmt = conn.prepareStatement(query);
                    stmt.setString(1, opt);
                    ResultSet valores = stmt.executeQuery();
                    if(valores.next()){
                        var novaQuery = "DELETE FROM tb_tarefas WHERE nome = ?";
                        PreparedStatement stmt2 = conn.prepareStatement(novaQuery);
                        stmt2.setString(1,opt);
                        stmt2.executeUpdate();
                        System.out.println("Tarefa excluida ");
                    }else{
                        System.out.println("Tarefa não encontrada");
                    }

                } catch (SQLDataException e) {
                    throw new RuntimeException(e);
                } catch (SQLException e) {
                    System.err.println(e.getMessage());
                }
                break;
            case "4":
                try(var conn = DB.connection()){
                    var query = "UPDATE tb_tarefas SET status = ?";
                    PreparedStatement stmt = conn.prepareStatement(query);
                    stmt.setString(1, "concluida");
                    stmt.executeUpdate();
                    System.out.println("Status atualizado para concluida");

                } catch (SQLDataException e) {
                    throw new RuntimeException(e);
                } catch (SQLException e) {
                    System.err.println(e.getMessage());
                }
                break;
            case "5":
                System.out.println("Quer procurar por categoria ou status?? ");
                String opcao = scan.nextLine().toLowerCase();
                if(opcao.toLowerCase().equals("categoria")){
                    System.out.println("Digite a categoria que deseja procurar: ");
                    String cat = scan.nextLine().toLowerCase();
                    try(var conn = DB.connection()){
                        var query = "SELECT * FROM tb_tarefas WHERE categoria = ?";
                        PreparedStatement stmt = conn.prepareStatement(query);
                        stmt.setString(1, cat);
                        ResultSet resultados = stmt.executeQuery();
                        if(resultados.next()){
                            System.out.println("Tarefas nessa categoria: ");
                            do{
                                System.out.println("Nome da Tarefa: " + resultados.getString("nome"));
                                System.out.println("Categoria da Tarefa: " + resultados.getString("categoria"));
                                System.out.println("Status da Tarefa: " + resultados.getString("status"));
                            }while(resultados.next());


                        }else{
                            System.out.println("Nenhuma tarefa nessa categoria...");
                        }

                    } catch (SQLDataException e) {
                        throw new RuntimeException(e);
                    } catch (SQLException e) {
                        System.err.println(e.getMessage());
                    }
                }else if(opcao.toLowerCase().equals("status")){
                    System.out.println("Digite o status que deseja procurar: ");
                    String stats = scan.nextLine().toLowerCase();
                    try(var conn = DB.connection()){
                        var query = "SELECT * FROM tb_tarefas WHERE status = ?";
                        PreparedStatement stmt = conn.prepareStatement(query);
                        stmt.setString(1, stats);
                        ResultSet resultados = stmt.executeQuery();
                        if(resultados.next()){
                            System.out.println("Tarefas nesse status: ");
                            do{
                                System.out.println("Nome da Tarefa: " + resultados.getString("nome"));
                                System.out.println("Categoria da Tarefa: " + resultados.getString("categoria"));
                                System.out.println("Status da Tarefa: " + resultados.getString("status") + "\n");
                            }while(resultados.next());
                        }else{
                            System.out.println("Nenhuma tarefa nesse status...");
                        }

                    } catch (SQLDataException e) {
                        throw new RuntimeException(e);
                    } catch (SQLException e) {
                        System.err.println(e.getMessage());
                    }
                }else{
                    System.out.println("Opção invalida...");
                }
                break;
            default:
                System.out.println("Opção Invalida...");
        }

    }

}