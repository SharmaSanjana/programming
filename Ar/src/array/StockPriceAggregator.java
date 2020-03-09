package array;

import java.util.*;

public class StockPriceAggregator {
    

	public static class StatisticsAggregatorImpl implements StatisticsAggregator {
	
	    class Statistics{ 
	        private Integer tickCount;
	        private Double avgPrice;
	        
	        Statistics(int tickCount, Double avgPrice){
	            this.tickCount = tickCount;
	            this.avgPrice = avgPrice;
	        }
	        public Integer getTickCount(){
	            return this.tickCount;
	        }
	        public void setTickCount(Integer tickCount){
	            this.tickCount = tickCount;
	        }
	        
	        public Double getAvgPrice() {
	            return this.avgPrice;
	        }
	        public void setAvgPrice(Double avgPrice) { 
	            this.avgPrice = avgPrice;
	        }
	        
	    }
	    private Map<String,Statistics> statisticsMap = new HashMap<>();
		@Override
		public void putNewPrice(String symbol, double price) {
			Statistics stats = statisticsMap.get(symbol);
			if(stats == null){
			    stats = new Statistics(1,price);
			    //new Statistics(tickCount, avgPrice);
			}else{
			    double avgPrice = ((stats.getAvgPrice()*stats.getTickCount()) + price) / ((stats.getTickCount() + 1)*1.0D);
			    stats.setAvgPrice(avgPrice);
			    stats.setTickCount(stats.getTickCount() + 1);
			}
			statisticsMap.put(symbol,stats);
			
		}

		@Override
		public double getAveragePrice(String symbol) {
			return statisticsMap.get(symbol).getAvgPrice();
		}

		@Override
		public int getTickCount(String symbol) {
		    return statisticsMap.get(symbol).getTickCount();
		}
		
	}

	////////////////// DO NOT MODIFY BELOW THIS LINE ///////////////////

	public interface StatisticsAggregator {
		// This is an input. Make note of this price.
		public void putNewPrice(String symbol, double price);

		// Get the average price
		public double getAveragePrice(String symbol);

		// Get the total number of prices recorded
		public int getTickCount(String symbol);
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			final StatisticsAggregator stats = new StatisticsAggregatorImpl();
			final Set<String> symbols = new TreeSet<>();

			String line = scanner.nextLine();
			String[] inputs = line.split(",");
			for (int i = 1; i < inputs.length; ++i) {
				String[] tokens = inputs[i].split(" ");
				final String symbol = tokens[0];
				symbols.add(symbol);
				final double price = Double.parseDouble(tokens[1]);

				stats.putNewPrice(symbol, price);

			}

			for (String symbol : symbols) {
				System.out.println(
						String.format("%s %.4f %d", symbol, stats.getAveragePrice(symbol), stats.getTickCount(symbol)));
			}
		}
		scanner.close();

	}
}
