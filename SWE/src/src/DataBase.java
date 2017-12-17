package src;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class DataBase implements IDataBase {

	private int ID;

	public DataBase() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("IDCounter.txt"));
			ID = Integer.parseInt(reader.readLine());
			reader.close();

		} catch (FileNotFoundException e) {
		} catch (IOException e) {

		}
	}

	public List<Product> RetreiveProduct(String ProductName) {
		List<String> catrgories = new ArrayList<>();
		List<String> files = new ArrayList<>();
		List<Product> products = new ArrayList<>();
		Path path = Paths.get("Categories.txt");
		try {
			catrgories = Files.readAllLines(path);
		} catch (IOException e1) {
		}
		for (String filename : catrgories) {
			path = Paths.get(filename + ".txt");
			try {
				files.addAll(Files.readAllLines(path));
			} catch (IOException e) {

			}
		}
		for (String filename : files) {
			if (filename.substring(0, filename.indexOf("_")).equals(ProductName)) {
				try {
					ObjectInputStream object = new ObjectInputStream(new FileInputStream(filename + ".txt"));
					products.add((Product) object.readObject());
					object.close();
				} catch (FileNotFoundException e) {
				} catch (IOException e) {
				} catch (ClassNotFoundException e) {
				}
			}
		}
		return products;
	}

	public User RetreiveUser(String username, String password) {
		List<String> users = new ArrayList<>();
		Path path = Paths.get("Users.txt");
		try {
			users = Files.readAllLines(path);
		} catch (IOException e) {
		}
		for (String user : users) {
			String[] arr = user.split("_");
			if (username.equals(arr[0]) && password.equals(arr[1])) {
				try {
					ObjectInputStream object = new ObjectInputStream(
							new FileInputStream(username + "_" + password + ".txt"));
					if (arr[2].equals("1")) {
						NormalUser normalUser = new NormalUser();
						normalUser = (NormalUser) object.readObject();
						object.close();
						return normalUser;
					} else if (arr[2].equals("2")) {
						StoreOwner storeOwner = new StoreOwner();
						storeOwner = (StoreOwner) object.readObject();
						object.close();
						return storeOwner;
					} else if (arr[2].equals("3")) {
						Administrator administrator = new Administrator();
						administrator = (Administrator) object.readObject();
						object.close();
						return administrator;
					}
					object.close();
				} catch (FileNotFoundException e) {

				} catch (IOException e) {

				} catch (ClassNotFoundException e) {
				}
			}
		}
		return null;
	}

	public List<String> RetreiveBrandsNames() {
		Path path = Paths.get("Categories.txt");
		try {
			return Files.readAllLines(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<String> RetreiveCategoriesNames() {
		Path path = Paths.get("Categories.txt");
		try {
			return Files.readAllLines(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Product> RetreiveCategoryProducts(String categoryName) {
		List<Product> list = new ArrayList<>();
		List<String> files = new ArrayList<>();
		Path path = Paths.get(categoryName + ".txt");
		try {
			files = Files.readAllLines(path);

		} catch (IOException e) {
		}
		for (String filename : files) {
			try {
				ObjectInputStream object = new ObjectInputStream(new FileInputStream(filename + ".txt"));
				try {
					list.add((Product) object.readObject());
				} catch (ClassNotFoundException e) {
				}
				object.close();
			} catch (FileNotFoundException e) {
				continue;
			} catch (IOException e) {
			}
		}
		return list;
	}

	public void InsertProductToCart(Cart cart) {
		UpdateUser(cart.getCartOwner());
	}

	public void InsertUser(User user) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("Users.txt", true));
			writer.write(user.getUsername() + "_" + user.getPassword() + "_" + user.getType());
			writer.newLine();
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		UpdateUser(user);
	}

	public void EmptyUserCart(NormalUser user) {
		UpdateUser(user);
	}

	public void InsertProductToStore(Store store, Product product) {
		product.setID(Integer.toString(ID));
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(product.getCategory() + ".txt", true));
			writer.write(product.getName() + "_" + product.getID());
			writer.newLine();
			writer.close();
		} catch (IOException e1) {
		}

		try {
			ObjectOutputStream object = new ObjectOutputStream(
					new FileOutputStream(product.getName() + "_" + product.getID() + ".txt"));
			object.writeObject(product);
			object.close();
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
		UpdateUser(store.getOwner());
		IncrementID();

	}

	public List<Product> RetreiveSysProducts() {
		List<Product> list = new ArrayList<>();
		List<String> files = new ArrayList<>();
		Path path = Paths.get("SystemProducts.txt");
		try {
			files = Files.readAllLines(path);

		} catch (IOException e) {
		}
		for (String filename : files) {
			try {
				ObjectInputStream object = new ObjectInputStream(new FileInputStream("System_" + filename + ".txt"));
				try {
					list.add((Product) object.readObject());
				} catch (ClassNotFoundException e) {
				}
				object.close();
			} catch (FileNotFoundException e) {
				continue;
			} catch (IOException e) {
			}
		}
		return list;
	}

	public void InsertProductToSystem(Product product) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("SystemProducts.txt", true));
			writer.write(product.getName());
			writer.newLine();
			writer.close();
		} catch (IOException e) {
		}

		try {
			ObjectOutputStream object = new ObjectOutputStream(
					new FileOutputStream("System_" + product.getName() + ".txt"));
			object.writeObject(product);
			object.close();
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
		deleteSuggestedProduct(product);
	}

	public void InsertSuggestedProduct(Product product) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("SuggestedProducts.txt", true));
			writer.write(product.getName());
			writer.newLine();
			writer.close();
		} catch (IOException e) {
		}
		try {
			ObjectOutputStream object = new ObjectOutputStream(
					new FileOutputStream("Suggested_" + product.getName() + ".txt"));
			object.writeObject(product);
			object.close();
		} catch (FileNotFoundException e) {

		} catch (IOException e) {

		}
	}

	@Override
	public void InsertNewStore(Store store) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("Stores.txt", true));
			writer.write(store.getStoreName() + "_" + store.getOwner().getUsername());
			writer.newLine();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			ObjectOutputStream object = new ObjectOutputStream(
					new FileOutputStream(store.getStoreName() + "_" + store.getOwner().getUsername() + ".txt"));
			object.writeObject(store);
			object.close();
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
		UpdateUser(store.getOwner());
	}

	@Override
	public void provideVoucherCard(String VoucherNo) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("VoucherCards.txt", true));
			writer.write(VoucherNo);
			writer.newLine();
			writer.close();
		} catch (IOException e) {
		}
	}

	@Override
	public boolean CheckVoucherCard(String VoucherNo) {
		Path path = Paths.get("VoucherCards.txt");
		try {
			return Files.readAllLines(path).contains(VoucherNo);
		} catch (IOException e) {
		}
		return false;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	protected void UpdateUser(User user) {
		ObjectOutputStream object;
		try {
			object = new ObjectOutputStream(
					new FileOutputStream(user.getUsername() + "_" + user.getPassword() + ".txt"));
			if (user instanceof NormalUser) {
				object.writeObject(((NormalUser) user));
			} else if (user instanceof StoreOwner) {
				object.writeObject(((StoreOwner) user));
			} else if (user instanceof Administrator) {
				object.writeObject(((Administrator) user));
			}
			object.close();
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}

	}

	protected void IncrementID() {
		ID++;
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("IDCounter.txt"));
			out.write(Integer.toString(ID));
			out.close();
		} catch (Exception e) {
		}

	}

	protected void deleteSuggestedProduct(Product product) {
		Path path = Paths.get("Suggested_" + product.getName() + ".txt");
		try {
			Files.delete(path);
		} catch (Exception e) {

		}
	}

	@Override
	public List<Product> RetreiveAllProducts() {
		List<String> catrgories = new ArrayList<>();
		List<String> files = new ArrayList<>();
		List<Product> products = new ArrayList<>();
		Path path = Paths.get("Categories.txt");
		try {
			catrgories = Files.readAllLines(path);
		} catch (IOException e1) {
		}
		for (String filename : catrgories) {
			path = Paths.get(filename + ".txt");
			try {

				files.addAll(Files.readAllLines(path));

			} catch (IOException e) {

			}
		}
		for (String filename : files) {
			try {
				ObjectInputStream object = new ObjectInputStream(new FileInputStream(filename + ".txt"));
				products.add((Product) object.readObject());
				object.close();
			} catch (FileNotFoundException e) {
			} catch (IOException e) {
			} catch (ClassNotFoundException e) {
			}

		}
		return products;
	}

	@Override
	public List<String> RetreiveStoreNames() {
		Path path = Paths.get("Stores.txt");
		try {
			return Files.readAllLines(path);
		} catch (IOException e) {
		}
		return new ArrayList<>();
	}

	@Override
	public List<Product> RetreiveSuggestedProduct() {
		List<Product> list = new ArrayList<>();
		List<String> files = new ArrayList<>();
		Path path = Paths.get("SuggestedProducts.txt");
		try {
			files = Files.readAllLines(path);

		} catch (IOException e) {
		}
		for (String filename : files) {
			try {
				ObjectInputStream object = new ObjectInputStream(new FileInputStream("Suggested_" + filename + ".txt"));
				try {
					list.add((Product) object.readObject());
				} catch (ClassNotFoundException e) {
				}
				object.close();
			} catch (FileNotFoundException e) {
				continue;
			} catch (IOException e) {
			}
		}
		return list;
	}

}